package com.luminteam.lumin.ui.screens.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.ReturnButton
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.screens.sections.components.LockedSectionButton
import com.luminteam.lumin.ui.screens.sections.components.UnlockedSectionButton

data class Section(
    val title: String,
    val description: String,
    val locked: Boolean
)

val sections: List<Section> = listOf<Section>(
    Section(title = "Sección 1", description = "Variables y Salidas", locked = false),
    Section(title = "Sección 2", description = "Tipos de Datos", locked = true),
    Section(title = "Sección 3", description = "Funciones", locked = true),
    Section(title = "Sección 4", description = "Bucles", locked = true)
)

@Composable
fun SectionsScreen(title: String, description: String) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        item {
            ReturnButton()
        }

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
fun SectionsScreenPreview() {
    LuminTheme {
        SectionsScreen(title = "Sección 1", description = "Variables y Salidas")
    }
}