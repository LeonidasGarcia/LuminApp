package com.luminteam.lumin.ui.navigation

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.ContentView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
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
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.luminteam.lumin.data.repository.LocalLoginRepository
import com.luminteam.lumin.data.repository.LocalSettingsRepository
import com.luminteam.lumin.ui.layout.BottomBar
import com.luminteam.lumin.ui.layout.TopBar
import com.luminteam.lumin.ui.screens.learn.chat.AiChatScreen
import com.luminteam.lumin.ui.screens.learn.levels.LevelsScreen
import com.luminteam.lumin.ui.screens.learn.section.SectionsScreen
import com.luminteam.lumin.ui.screens.learn.theory.TheoryScreen
import com.luminteam.lumin.ui.screens.login.LoginScreen
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.viewmodels.AIChatViewModel
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.SettingsViewModel
import com.luminteam.lumin.ui.viewmodels.SignInViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun MainNavigation(
    signInViewModel: SignInViewModel,
    userViewModel: UserViewModel,
    settingsViewModel: SettingsViewModel,
    contentViewModel: ContentViewModel,
    modifier: Modifier = Modifier
) {
    val loginRepository = LocalLoginRepository.current
    val token by loginRepository.jwt.collectAsStateWithLifecycle(initialValue = null)

    val systemUiController = rememberSystemUiController()

    Log.d("Token revision", token.toString())

    SideEffect {
        systemUiController.setStatusBarColor(
            color = LuminBackground
        )
    }

    if (!token.isNullOrEmpty()) {
        Log.d("Token Revision", token.toString())
        RootNavigation(
            userViewModel = userViewModel,
            settingsViewModel = settingsViewModel,
            contentViewModel = contentViewModel
        )
        return
    }

    Log.d("Token Revision", "Cargando login")
    LoginScreen(
        signInViewModel = signInViewModel
    )
}