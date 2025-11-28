package com.luminteam.lumin.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.TopBarBackAction
import com.luminteam.lumin.ui.domain.TitleTopBar
import com.luminteam.lumin.ui.domain.TopBarRightButtonActionType
import com.luminteam.lumin.ui.screens.learn.chat.AiChatScreen
import com.luminteam.lumin.ui.screens.learn.chat.AiFeedbackChatScreen
import com.luminteam.lumin.ui.screens.learn.levels.LevelsScreen
import com.luminteam.lumin.ui.screens.learn.practice.PracticeResultsScreen
import com.luminteam.lumin.ui.screens.learn.practice.PracticeScreen
import com.luminteam.lumin.ui.screens.learn.section.SectionsScreen
import com.luminteam.lumin.ui.screens.learn.theory.TheoryScreen
import com.luminteam.lumin.ui.viewmodels.AIChatViewModel
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.Serializable

@Serializable
data object LevelNavigation : NavKey

@Composable
fun LevelNavigation(
    rootViewModel: RootNavigationViewModel,
    userViewModel: UserViewModel,
    contentViewModel: ContentViewModel,
    aiChatViewModel: AIChatViewModel,
    viewModel: LevelNavigationViewModel = viewModel(),
    levelBackStack: NavBackStack<NavKey>
) {
    Log.d("revision", "level nav cargado")
    val backStack = levelBackStack
    val updateCurrentBackAction: (TopBarBackAction) -> Unit = { backAction ->
        rootViewModel.updateCurrentTopBarBackAction(backAction)
    }
    val updateCanGoBack: (Boolean) -> Unit = { canGoBack ->
        rootViewModel.updateCanGoBack(canGoBack)
    }

    val updateShowBottomBar: (Boolean) -> Unit = {
        rootViewModel.updateShowBottomBar(it)
    }

    val updateCurrentTitleTopBar: (TitleTopBar) -> Unit = {
        rootViewModel.updateCurrentTitleTopBar(it)
    }

    val updateCurrentTopBarRightButtonActionType: (TopBarRightButtonActionType) -> Unit = {
        rootViewModel.updateCurrentTopBarRightButtonActionType(it)
    }

    val updateShowTopBarRightButton: (Boolean) -> Unit = {
        rootViewModel.updateShowTopBarRightButton(it)
    }

    val userId = userViewModel.currentUserData.collectAsStateWithLifecycle().value.id

    val currentAppContentState =
        viewModel.currentAppContentState.collectAsStateWithLifecycle().value

    val levels = contentViewModel.levels.collectAsStateWithLifecycle().value
    val sections = contentViewModel.sections.collectAsStateWithLifecycle().value


    NavDisplay(
        backStack = backStack,
        modifier = Modifier
            .fillMaxSize(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<LevelsScreen> {
                Log.d("revision", "levels cargado")
                updateCurrentBackAction() {}
                updateCanGoBack(false)
                updateShowBottomBar(true)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Aprender",
                        iconTitle = R.drawable.learn_icon
                    )
                )

                LevelsScreen(
                    contentViewModel = contentViewModel,
                    userViewModel = userViewModel,
                    viewModel = viewModel,
                    navigateSection = {
                        backStack.add(SectionsScreen)
                    })
            }
            entry<PracticeScreen> {
                // siempre debe recargar todas las preguntas al entrar a este lugar
                // se debe implementar una manera de vaciar todas las preguntas cuando se termina el proceso de práctica!!!!


                val currentLevelName = levels.levels[currentAppContentState.currentLevelId]!!.name
                val currentSectionName =
                    sections.sections[currentAppContentState.currentSectionId]!!.name

                // cargamos la practica
                LaunchedEffect(Unit) {
                    viewModel.loadPractice(currentLevelName, currentSectionName)
                }

                updateCurrentBackAction() {
                    // más operacioes para limpiar el estado de la practica
                    backStack.removeLastOrNull()
                }
                updateCanGoBack(true)
                updateShowBottomBar(false)

                val questions =
                    viewModel.questionsUiState.collectAsStateWithLifecycle().value.questions

                if (questions.isEmpty()) {
                    Text("cargando practica...")
                } else {
                    // actualizamos los datos del usuario
                    LaunchedEffect(Unit) {
                        userViewModel.loadUserData()
                    }
                    PracticeScreen(
                        viewModel = viewModel,
                        updateCurrentTitleTopBar = { title, iconTitle ->
                            updateCurrentTitleTopBar(
                                TitleTopBar(
                                    title = title,
                                    iconTitle = iconTitle
                                )
                            )
                        },
                        navigatePracticeResults = {
                            backStack.removeLastOrNull()
                            backStack.add(PracticeResultsScreen)
                        }
                    )
                }


            }

            entry<TheoryScreen> {
                Log.d("revision", "theory cargado")
                updateCurrentBackAction() {
                    /*
                    viewModel.updateCurrentAppContentState(
                        currentAppContentState.copy(
                            currentPageId = null
                        )
                    )
                     */

                    aiChatViewModel.clearMessages()
                    updateCurrentTopBarRightButtonActionType(TopBarRightButtonActionType.SHOW_LIVES)
                    backStack.removeLastOrNull()
                }
                updateCanGoBack(true)
                updateShowBottomBar(false)
                updateCurrentTopBarRightButtonActionType(TopBarRightButtonActionType.SHOW_AI_CHAT)

                TheoryScreen(
                    rootViewModel = rootViewModel,
                    contentViewModel = contentViewModel,
                    viewModel = viewModel,
                    navigateSection = {
                        backStack.removeLastOrNull()
                    },
                    updateCurrentTitleTopBar = { title, iconTitle ->
                        updateCurrentTitleTopBar(
                            TitleTopBar(
                                title = title,
                                iconTitle = iconTitle
                            )
                        )
                    }
                )
            }

            entry<PracticeResultsScreen> {

                LaunchedEffect(Unit) {
                    val userId = userId
                    val sectionId = currentAppContentState.currentSectionId!!

                    viewModel.loadPracticeResults(userId = userId, sectionId = sectionId)
                }

                updateCurrentBackAction() {
                    backStack.removeLastOrNull()
                }
                updateCanGoBack(true)
                updateShowBottomBar(true)

                //viewModel.loadMockResults()

                val practiceResults =
                    viewModel.questionsResultsUiState.collectAsStateWithLifecycle().value

                Log.d("Results", practiceResults.questionsResults.toString())

                if (practiceResults.questionsResults.isEmpty()) {
                    Text("cargando resultados...")
                } else {
                    LaunchedEffect(Unit) {
                        userViewModel.loadUserData()
                    }
                    PracticeResultsScreen(
                        viewModel = viewModel,
                        navigateFeedback = {
                            backStack.add(AiFeedbackChatScreen)
                        }
                    )
                }
            }
            entry<SectionsScreen> {
                Log.d("revision", "section cargado")
                updateCurrentBackAction() {
                    /*
                    viewModel.updateCurrentAppContentState(
                        currentAppContentState.copy(
                            currentLevelId = null,
                            currentSectionId = null
                        )
                    )

                     */
                    backStack.removeLastOrNull()
                }
                updateCanGoBack(true)
                updateShowBottomBar(true)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Sección",
                        iconTitle = R.drawable.book_icon
                    )
                )

                SectionsScreen(
                    userViewModel = userViewModel,
                    contentViewModel = contentViewModel,
                    viewModel = viewModel,
                    navigateTheory = {
                        backStack.add(TheoryScreen)
                    },
                    navigatePractice = {
                        backStack.add(PracticeScreen)
                    }
                )
            }
            entry<AiChatScreen> {
                updateCurrentBackAction() {
                    backStack.removeLastOrNull()
                    updateShowTopBarRightButton(true)
                }
                updateCanGoBack(true)
                updateShowBottomBar(false)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Tutor IA",
                        iconTitle = R.drawable.robot_icon
                    )
                )
                updateShowTopBarRightButton(false)

                AiChatScreen(
                    aiChatViewModel = aiChatViewModel
                )
            }
            entry<AiFeedbackChatScreen> {
                updateCurrentBackAction() {
                    updateShowTopBarRightButton(true)
                    backStack.removeLastOrNull()
                }
                updateCanGoBack(true)
                updateShowBottomBar(false)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Retroalimentación IA",
                        iconTitle = R.drawable.robot_icon
                    )
                )
                updateShowTopBarRightButton(false)

                AiFeedbackChatScreen(
                    viewModel = viewModel,
                    aiChatViewModel = aiChatViewModel
                )
            }
        }
    )
}