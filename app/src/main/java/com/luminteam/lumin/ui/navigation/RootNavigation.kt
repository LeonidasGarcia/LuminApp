package com.luminteam.lumin.ui.navigation

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.luminteam.lumin.data.repository.LocalSettingsRepository
import com.luminteam.lumin.ui.layout.BottomBar
import com.luminteam.lumin.ui.layout.TopBar
import com.luminteam.lumin.ui.screens.learn.chat.AiChatScreen
import com.luminteam.lumin.ui.screens.learn.levels.LevelsScreen
import com.luminteam.lumin.ui.screens.learn.section.SectionsScreen
import com.luminteam.lumin.ui.screens.learn.theory.TheoryScreen
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.viewmodels.AIChatViewModel
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.SettingsViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data object RootNavigation : NavKey

@Composable
fun RootNavigation(
    viewModel: RootNavigationViewModel = viewModel(),

    //No debes poner viewModel por default a los que ya estan funcionales
    userViewModel: UserViewModel,
    settingsViewModel: SettingsViewModel,
    contentViewModel: ContentViewModel,
    aiChatViewModel: AIChatViewModel,
    levelNavigationViewModel: LevelNavigationViewModel,
    modifier: Modifier = Modifier
) {
    // Esto es para que Lumin te pregunte si quieres notificaciones cuando abras la app por primera vez
    val context = LocalContext.current
    val settingsRepository = LocalSettingsRepository.current
    val scope = rememberCoroutineScope()

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { isGranted ->
        scope.launch {
            settingsRepository.saveDailyReminder(isGranted)
        }
    }

    LaunchedEffect(null) {
        userViewModel.loadUserData()
        contentViewModel.loadContent()
    }

    LaunchedEffect(Unit) {
        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }
    //

    val backStack = rememberNavBackStack(HomeNavigation)
    val systemUiController = rememberSystemUiController()

    var profilePhotoUri by remember { mutableStateOf<String>("") }

    var currentRoute by remember { mutableStateOf("MainScreen") }

    var currentUserData = userViewModel.currentUserData.collectAsStateWithLifecycle().value

    val levelBackStack = rememberNavBackStack(LevelsScreen)

    val currentBackActionState = viewModel.currentTopBarBackAction.collectAsStateWithLifecycle()
    val currentBackAction = currentBackActionState.value

    val canGoBackState = viewModel.canGoBack.collectAsStateWithLifecycle()
    val canGoBack = canGoBackState.value

    val showGeneralPaddingState = viewModel.showGeneralPadding.collectAsStateWithLifecycle()
    val showGeneralPadding = showGeneralPaddingState.value

    val showBottomBarState = viewModel.showBottomBar.collectAsStateWithLifecycle()
    val showBottomBar = showBottomBarState.value

    val currentTitleTopBarState = viewModel.currentTitleTopBar.collectAsStateWithLifecycle()
    val currentTitleTopBar = currentTitleTopBarState.value

    val currentTopBarRightButtonActionTypeState =
        viewModel.currentTopBarRightButtonActionType.collectAsStateWithLifecycle()
    val currentTopBarRightButtonActionType = currentTopBarRightButtonActionTypeState.value

    val showTopBarRightButtonState = viewModel.showTopBarRightButton.collectAsStateWithLifecycle()
    val showTopBarRightButton = showTopBarRightButtonState.value

    val generalPadding = if (showGeneralPadding) 20.dp else 0.dp

    val currentUserContentState =
        userViewModel.currentUserContentState.collectAsStateWithLifecycle().value


    // con esta navegacion especial, se tienen que hacer las operaciones de manera manual y en orden
    fun navigateCurrentTheoryPage() {
        levelNavigationViewModel.updateCurrentAppContentState(
            currentUserContentState
        )

        backStack.removeLastOrNull()
        backStack.add(LevelNavigation)
        levelBackStack.add(SectionsScreen)
        levelBackStack.add(TheoryScreen)
        currentRoute = "SectionsScreen"

    }

    LaunchedEffect(null) {
        profilePhotoUri = userViewModel.getProfilePhotoUri()
        Log.d("Foto de perfil", profilePhotoUri)
    }

    SideEffect {
        systemUiController.setStatusBarColor(
            color = LuminBackground
        )
    }

    Scaffold(
        modifier = Modifier.imePadding(),
        bottomBar = {
            BottomBar(
                navigateHome = {
                    backStack.removeLastOrNull()
                    backStack.add(HomeNavigation)
                },
                navigateProfile = {
                    backStack.removeLastOrNull()
                    backStack.add(ProfileNavigation)
                },
                navigateLevel = {
                    backStack.removeLastOrNull()
                    backStack.add(LevelNavigation)
                },
                navigateSettings = {
                    backStack.removeLastOrNull()
                    backStack.add(SettingsNavigation)
                },
                showBottomBar = showBottomBar,
                currentRoute = currentRoute,
                setCurrentRoute = {
                    currentRoute = it
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(color = LuminBackground)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                TopBar(
                    canGoBack = canGoBack,
                    onBack = {
                        currentBackAction()
                    },
                    titleTopBar = currentTitleTopBar,
                    lives = currentUserData.lives,
                    currentRightButtonActionType = currentTopBarRightButtonActionType,
                    navigateAiChat = {
                        // operaciones (si es que son necesarias)
                        levelBackStack.add(AiChatScreen)
                    },
                    showTopBarRightButton = showTopBarRightButton
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            bottom = generalPadding,
                            start = generalPadding,
                            end = generalPadding
                        ),
                ) {
                    NavDisplay(
                        backStack = backStack,
                        modifier = Modifier.weight(1f),
                        entryDecorators = listOf(
                            rememberSaveableStateHolderNavEntryDecorator(),
                            rememberViewModelStoreNavEntryDecorator()
                        ), entryProvider = entryProvider {
                            entry<HomeNavigation> {
                                viewModel.updateShowGeneralPadding(true)
                                HomeNavigation(
                                    rootViewModel = viewModel,
                                    navigateCurrentTheoryPage = {
                                        navigateCurrentTheoryPage()
                                    }
                                )
                            }
                            entry<ProfileNavigation> {
                                ProfileNavigation(
                                    rootViewModel = viewModel,
                                    userViewModel = userViewModel,
                                    contentViewModel = contentViewModel,
                                    profilePhotoUri = profilePhotoUri
                                )
                            }
                            entry<LevelNavigation> {
                                viewModel.updateShowGeneralPadding(true)
                                LevelNavigation(
                                    rootViewModel = viewModel,
                                    userViewModel = userViewModel,
                                    contentViewModel = contentViewModel,
                                    viewModel = levelNavigationViewModel,
                                    levelBackStack = levelBackStack,
                                    aiChatViewModel = aiChatViewModel,
                                )
                            }
                            entry<SettingsNavigation> {
                                viewModel.updateShowGeneralPadding(true)
                                SettingsNavigation(
                                    rootViewModel = viewModel,
                                    settingsViewModel = settingsViewModel
                                )
                            }
                        }
                    )

                }
            }

        }


    }
}