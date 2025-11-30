package com.luminteam.lumin.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminLoading
import com.luminteam.lumin.ui.domain.TopBarBackAction
import com.luminteam.lumin.ui.domain.TitleTopBar
import com.luminteam.lumin.ui.screens.home.HomeScreen
import com.luminteam.lumin.ui.screens.learn.chat.AiFeedbackChatScreen
import com.luminteam.lumin.ui.screens.learn.practice.PracticeResultsScreen
import com.luminteam.lumin.ui.screens.learn.practice.PracticeScreen
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable
import kotlin.collections.get

@Serializable
data object HomeNavigation : NavKey

@Composable
fun HomeNavigation(
    rootViewModel: RootNavigationViewModel,
    levelNavigationViewModel: LevelNavigationViewModel,
    contentViewModel: ContentViewModel,
    userViewModel: UserViewModel,
    navigateCurrentTheoryPage: () -> Unit
) {
    val updateCurrentBackAction: (TopBarBackAction) -> Unit = {
        rootViewModel.updateCurrentTopBarBackAction(it)
    }
    val updateCanGoBack: (Boolean) -> Unit = {
        rootViewModel.updateCanGoBack(it)
    }

    val updateShowBottomBar: (Boolean) -> Unit = {
        rootViewModel.updateShowBottomBar(it)
    }

    val updateCurrentTitleTopBar: (TitleTopBar) -> Unit = {
        rootViewModel.updateCurrentTitleTopBar(it)
    }

    val currentAppContentState =
        levelNavigationViewModel.currentAppContentState.collectAsStateWithLifecycle().value

    val currentUserSectionId =
        userViewModel.currentUserMetricsData.collectAsStateWithLifecycle().value.currentSectionId

    val levels = contentViewModel.levels.collectAsStateWithLifecycle().value
    val sections = contentViewModel.sections.collectAsStateWithLifecycle().value

    val backStack = rememberNavBackStack(HomeScreen)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<HomeScreen> {
                updateCurrentBackAction() {}
                updateCanGoBack(false)
                updateShowBottomBar(true)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Inicio",
                        iconTitle = R.drawable.home_icon
                    )
                )

                HomeScreen(
                    navigateCurrentTheoryPage = navigateCurrentTheoryPage,
                    navigateDailyPractice = {
                        backStack.add(PracticeScreen)
                    })
            }
            entry<PracticeScreen> {
                // siempre debe recargar todas las preguntas al entrar a este lugar
                // se debe implementar una manera de vaciar todas las preguntas cuando se termina el proceso de práctica!!!!
                /*
                    updateCurrentTitleTopBar(
                        TitleTopBar(
                            title = "Práctica Diaria",
                            iconTitle = R.drawable.practice_icon
                        )
                    )
                    */

                // cargamos la practica diaria
                LaunchedEffect(Unit) {
                    levelNavigationViewModel.loadDailyPractice()
                }

                updateCurrentBackAction() {
                    // más operaciones para limpiar el estado de la practica
                    levelNavigationViewModel.resetPractice()
                    levelNavigationViewModel.resetPracticeResults()

                    backStack.removeLastOrNull()
                }
                updateCanGoBack(true)
                updateShowBottomBar(false)

                val questions =
                    levelNavigationViewModel.questionsUiState.collectAsStateWithLifecycle().value.questions

                if (questions.isEmpty()) {
                    LuminLoading()
                } else {
                    // actualizamos los datos del usuario
                    LaunchedEffect(Unit) {
                        userViewModel.loadUserData()
                    }

                    PracticeScreen(
                        viewModel = levelNavigationViewModel,
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

            entry<PracticeResultsScreen> {

                LaunchedEffect(Unit) {
                    val sectionId = currentUserSectionId

                    levelNavigationViewModel.loadDailyPracticeResults(sectionId = currentUserSectionId)
                }

                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Feedback",
                        iconTitle = R.drawable.results_icon
                    )
                )

                updateCurrentBackAction() {
                    levelNavigationViewModel.resetPracticeResults()
                    levelNavigationViewModel.resetPracticeResults()
                    backStack.removeLastOrNull()
                }
                updateCanGoBack(true)
                updateShowBottomBar(true)

                //viewModel.loadMockResults()

                val practiceResults =
                    levelNavigationViewModel.questionsResultsUiState.collectAsStateWithLifecycle().value

                Log.d("Results", practiceResults.questionsResults.toString())

                if (practiceResults.questionsResults.isEmpty()) {
                    LuminLoading()
                } else {
                    LaunchedEffect(Unit) {
                        userViewModel.loadUserData()
                    }

                    PracticeResultsScreen(
                        viewModel = levelNavigationViewModel,
                        navigateFeedback = {
                            backStack.add(AiFeedbackChatScreen)
                        },
                        retryPractice = {
                            levelNavigationViewModel.resetPractice()
                            levelNavigationViewModel.resetPracticeResults()
                            backStack.removeLastOrNull()
                            backStack.add(PracticeScreen)
                        },
                        navigateCurrentTheoryPage = {
                            backStack.removeLastOrNull()
                            backStack.removeLastOrNull()
                            navigateCurrentTheoryPage()
                        },
                        isCurrentSection = false
                    )
                }
            }
        }
    )
}