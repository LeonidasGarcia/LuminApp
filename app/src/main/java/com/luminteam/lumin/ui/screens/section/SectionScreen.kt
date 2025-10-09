package com.luminteam.lumin.ui.screens.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.ReturnButton
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.screens.section.components.ModuleButton

@Composable
fun SectionScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        ReturnButton()
        Text(
            text = "Variables y Salidas",
            color = LuminWhite,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            color = LuminLightGray,
            lineHeight = 25.sp
        )
        Text(
            text = "Elige el módulo",
            color = LuminWhite,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            ModuleButton(
                title = "Teoría",
                details = "5 páginas",
                icon = R.drawable.theory_icon,
                selected = true
            )
            ModuleButton(
                title = "Práctica",
                details = "0 intentos",
                icon = R.drawable.evaluation_icon,
                selected = false
            )
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