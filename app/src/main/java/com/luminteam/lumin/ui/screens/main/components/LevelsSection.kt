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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminGray
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.LuminYellow

data class Level(
    val title: String,
    val titleColor: Color,
    val buttonColor: Color,
    val icon: Int,
    val iconColor: Color,
    val description: String
)

val levels = listOf<Level>(
    Level(
        title = "Básico",
        titleColor = LuminBlack,
        buttonColor = LuminGreen,
        icon = R.drawable.easy_icon,
        iconColor = LuminBlack,
        description = "Lo fundamental"
    ),
    Level(
        title = "Intermedio",
        titleColor = LuminBlack,
        buttonColor = LuminYellow,
        icon = R.drawable.medium_icon,
        iconColor = LuminBlack,
        description = "Sube tu nivel"
    ),
    Level(
        title = "Avanzado",
        titleColor = LuminBlack,
        buttonColor = LuminOrange,
        icon = R.drawable.hard_icon,
        iconColor = LuminBlack,
        description = "Conviertete en un experto"
    )
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
    levels.forEach { (title, titleColor, buttonColor, icon, iconColor, description) ->
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