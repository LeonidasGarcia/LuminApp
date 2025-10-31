package com.luminteam.lumin.ui.screens.practice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.ui.screens.practice.components.questions.CompleteTheCode
import com.luminteam.lumin.ui.screens.practice.components.questions.FixTheCode
import com.luminteam.lumin.ui.screens.practice.components.questions.FreeResponse
import com.luminteam.lumin.ui.screens.practice.components.questions.SingleSelection
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