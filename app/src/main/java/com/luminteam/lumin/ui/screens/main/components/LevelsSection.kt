package com.luminteam.lumin.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.data.LevelData
import com.luminteam.lumin.data.levels.basic.BasicLevel
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.screens.main.MainScreen
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.LuminYellow

val levels = listOf<LevelData>(
    BasicLevel
)

@Composable
fun LevelsSection() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            LevelsHeader()
            Levels()
        }
    }
}

@Composable
fun LevelsHeader() {
    Text(
        text = "Niveles", color = LuminWhite,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun Levels() {
    levels.forEach { (title, _, titleColor, buttonColor, icon, iconColor, description) ->
        LuminButton(
            title = title,
            titleColor = titleColor,
            buttonColor = buttonColor,
            icon = icon,
            iconColor = iconColor,
            modifier = Modifier.padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(text = description, color = LuminGray, fontSize = 12.sp, fontWeight = FontWeight.Medium)
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
        LevelsSection()
    }
}