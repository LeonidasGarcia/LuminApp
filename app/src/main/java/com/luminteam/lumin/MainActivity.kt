package com.luminteam.lumin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luminteam.lumin.data.repository.AppConfig
import com.luminteam.lumin.util.alarm.AlarmScheduler
import com.luminteam.lumin.data.repository.LocalAlarmScheduler
import com.luminteam.lumin.data.repository.LocalAppConfig
import com.luminteam.lumin.data.repository.LocalLoginRepository
import com.luminteam.lumin.data.repository.LocalSettingsRepository
import com.luminteam.lumin.data.repository.LocalSoundManager
import com.luminteam.lumin.data.repository.LocalVibrationManager
import com.luminteam.lumin.data.repository.LoginRepository
import com.luminteam.lumin.data.repository.SettingsRepository
import com.luminteam.lumin.services.luminapi.repositories.authRepository
import com.luminteam.lumin.ui.navigation.MainNavigation
import com.luminteam.lumin.ui.navigation.RootNavigation
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.SettingsViewModel
import com.luminteam.lumin.ui.viewmodels.SignInViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import com.luminteam.lumin.util.sound.SoundManager
import com.luminteam.lumin.util.vibration.VibrationManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val settingsRepository = SettingsRepository(applicationContext)
        val loginRepository = LoginRepository(applicationContext)

        val alarmScheduler = AlarmScheduler(applicationContext)
        val vibrationManager = VibrationManager(applicationContext)
        val soundManager = SoundManager(applicationContext)

        setContent {
            val isSfxOn by settingsRepository.isSfxOn.collectAsState(initial = true)
            val appConfig = AppConfig(isSfxOn = isSfxOn)

            CompositionLocalProvider(
                // Los repos
                LocalSettingsRepository provides settingsRepository,
                LocalLoginRepository provides loginRepository,

                LocalAlarmScheduler provides alarmScheduler,
                LocalVibrationManager provides vibrationManager,
                LocalSoundManager provides soundManager,
                LocalAppConfig provides appConfig
            ) {
                LuminTheme {
                    // Aca instancias los viewModels

                    val signInViewModel: SignInViewModel = viewModel(
                        factory = SignInViewModel.provideFactory(loginRepository)
                    )

                    val userViewModel: UserViewModel = viewModel(
                        factory = UserViewModel.provideFactory(
                            loginRepository
                        )
                    )

                    val contentViewModel: ContentViewModel = viewModel(
                        factory = ContentViewModel.provideFactory(
                            loginRepository
                        )
                    )

                    val settingsViewModel: SettingsViewModel = viewModel(
                        factory = SettingsViewModel.provideFactory(
                            settingsRepository, loginRepository, alarmScheduler,
                        )
                    )

                    MainNavigation(
                        signInViewModel = signInViewModel,
                        userViewModel = userViewModel,
                        settingsViewModel = settingsViewModel,
                        contentViewModel = contentViewModel
                    )
                }
            }
        }
    }
}