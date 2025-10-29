package com.luminteam.lumin.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.ui.components.LuminContinueButton
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.screens.main.components.LevelsSection
import com.luminteam.lumin.ui.screens.main.components.MainHeader
import kotlinx.serialization.Serializable

@Serializable
data object MainScreen : NavKey

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                MainHeader()
                LuminContinueButton()
                LevelsSection()
            }
        }
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