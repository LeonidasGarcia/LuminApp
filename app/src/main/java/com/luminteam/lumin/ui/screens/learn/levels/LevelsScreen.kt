package com.luminteam.lumin.ui.screens.learn.levels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.data.SectionData
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.screens.learn.levels.components.LockedSectionButton
import com.luminteam.lumin.ui.screens.sections.components.UnlockedSectionButton
import kotlinx.serialization.Serializable

val sections: List<SectionData> = listOf<SectionData>(
    SequentialExecution,
    SequentialExecution,
    SequentialExecution,
    SequentialExecution
)

@Serializable
data object LevelsScreen : NavKey

@Composable
fun LevelsScreen(title: String, description: String) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        item {
            Text(
                text = "Secciones",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = LuminWhite
            )
        }

        items(items = sections) { (title, description, locked) ->
            if (locked) {
                LockedSectionButton(title = title, description = description)
            } else {
                UnlockedSectionButton(title = title, description = description)
            }
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
        LevelsScreen(title = "Sección 1", description = "Variables y Salidas")
    }
}