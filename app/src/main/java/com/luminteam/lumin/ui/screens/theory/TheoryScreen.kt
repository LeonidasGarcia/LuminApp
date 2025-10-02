package com.luminteam.lumin.ui.screens.theory

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.ui.components.ReturnButton
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun TheoryScreen() {
    LazyColumn {
        item {
            ReturnButton()
        }


    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun TheoryScreenPreview() {
    LuminTheme {
        TheoryScreen()
    }
}