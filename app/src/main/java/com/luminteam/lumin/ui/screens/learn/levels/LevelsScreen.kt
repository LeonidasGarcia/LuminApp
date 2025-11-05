package com.luminteam.lumin.ui.screens.learn.levels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.data.LevelData
import com.luminteam.lumin.data.SectionData
import com.luminteam.lumin.data.levels.basic.AdvancedLevel
import com.luminteam.lumin.data.levels.basic.BasicLevel
import com.luminteam.lumin.data.levels.basic.IntermediateLevel
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution
import com.luminteam.lumin.ui.components.LevelAccordion
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.screens.learn.levels.components.LockedSectionButton
import com.luminteam.lumin.ui.screens.sections.components.UnlockedSectionButton
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminDarkestGray
import com.luminteam.lumin.ui.theme.LuminGreen
import kotlinx.serialization.Serializable

@Serializable
data object LevelsScreen : NavKey

@Composable
fun LevelsScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            TitleText(
                text = "Niveles"
            )
        }

        item {
            ParagraphText(
                text = "Elige el nivel de conocimientos en el que te encuentras."
            )
        }

        items(
            items = listOf<LevelData>(
                BasicLevel,
                IntermediateLevel,
                AdvancedLevel
            )
        ) { level ->
            LevelAccordion(
                title = level.name,
                description = level.description,
                icon = level.icon,
                unfoldedIconColor = level.iconColor,
                foldedIconColor = LuminBlack,
                unfoldedBackgroundColor = LuminDarkestGray,
                foldedBackgroundColor = level.buttonColor,
                unfoldedTextColor = LuminWhite,
                foldedTextColor = LuminBlack,
                sections = level.sections
            )
        }

    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LevelsScreenPreview() {
    LuminTheme {
        LevelsScreen()
    }
}