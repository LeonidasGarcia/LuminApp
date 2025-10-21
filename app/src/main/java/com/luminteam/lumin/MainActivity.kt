package com.luminteam.lumin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.screens.practice.components.questions.CompleteTheCode
import com.luminteam.lumin.ui.theme.LuminBlack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LuminTheme {
                Box(
                    modifier = Modifier.background(LuminBlack)
                ) {
                    CompleteTheCode()
                }
            }
        }
    }
}



