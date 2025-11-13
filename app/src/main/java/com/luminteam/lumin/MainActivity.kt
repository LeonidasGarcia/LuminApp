package com.luminteam.lumin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.luminteam.lumin.ui.navigation.RootNavigation
import com.luminteam.lumin.ui.screens.learn.practice.PracticeScreen
import com.luminteam.lumin.ui.screens.login.LoginScreen
import com.luminteam.lumin.ui.theme.LuminTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            LuminTheme {
                RootNavigation()
            }
        }
    }
}