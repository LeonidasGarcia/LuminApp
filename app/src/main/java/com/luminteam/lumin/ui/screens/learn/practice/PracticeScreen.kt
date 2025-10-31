package com.luminteam.lumin.ui.screens.learn.practice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.ui.screens.learn.practice.components.questions.FreeResponse
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun PracticeScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            FreeResponse()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun PracticeScreenPreview() {
    LuminTheme {
        PracticeScreen()
    }
}