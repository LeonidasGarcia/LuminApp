package com.luminteam.lumin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.luminteam.lumin.ui.screens.login.LoginScreen
import com.luminteam.lumin.ui.theme.LuminTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LuminTheme {
                LoginScreen()
            }
        }
    }
}