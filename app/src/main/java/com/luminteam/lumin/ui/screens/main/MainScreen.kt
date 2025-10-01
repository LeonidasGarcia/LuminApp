package com.luminteam.lumin.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminSoftGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.LuminYellow
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.screens.main.components.ContinueButton
import com.luminteam.lumin.ui.screens.main.components.Levels
import com.luminteam.lumin.ui.screens.main.components.LevelsSection
import com.luminteam.lumin.ui.screens.main.components.MainHeader

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(36.dp)) {
        MainHeader()
        ContinueButton()
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