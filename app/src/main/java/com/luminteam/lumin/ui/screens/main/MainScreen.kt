package com.luminteam.lumin.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.ui.components.LuminContinueButton
import com.luminteam.lumin.ui.layouts.MainLayout
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.screens.main.components.LevelsSection
import com.luminteam.lumin.ui.screens.main.components.MainHeader

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    MainLayout {
        MainHeader()
        LuminContinueButton()
        LevelsSection()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun MainScreenPreview() {
    LuminTheme {
        MainScreen()
    }
}