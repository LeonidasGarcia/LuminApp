package com.luminteam.lumin.ui.screens.learn.section

import androidx.compose.foundation.layout.Arrangement
import com.luminteam.lumin.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.ui.components.LuminContentThemeButtonDefaults
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.components.LuminSquareButtonAlt
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.theme.LuminDarkGray

@Composable
fun SectionScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TitleText(
                text = "Interacción y representación de datos"
            )
        }
        item {
            ParagraphText(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            )
        }
        item {
            TitleText(
                text = "Elige el módulo"
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                LuminSquareButtonAlt(
                    title = "Teoría",
                    icon = R.drawable.theory_icon,
                    description = "5 páginas"
                )
                Spacer(modifier = Modifier.weight(1f))
                LuminSquareButtonAlt(
                    color = LuminDarkGray,
                    title = "Práctica",
                    icon = R.drawable.practice_icon,
                    description = "0 intentos",
                    contentTheme = LuminContentThemeButtonDefaults.dark
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun SectionScreenPreview() {
    LuminTheme {
        SectionScreen()
    }
}