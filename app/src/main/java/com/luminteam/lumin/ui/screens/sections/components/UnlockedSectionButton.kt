package com.luminteam.lumin.ui.screens.sections.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminSoftGray
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun UnlockedSectionButton(title: String, description: String) {
    LuminButton(
        title = title,
        titleColor = LuminBlack,
        buttonColor = LuminCyan,
        icon = R.drawable.arrow_icon,
        iconColor = LuminBlack,
        modifier = Modifier.padding(10.dp)
    ) {
        Column {
            Text(text = description, color = LuminSoftGray)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun UnlockedSectionButtonPreview() {
    LuminTheme {
        UnlockedSectionButton(title = "Sección 2", description = "Tipos de Datos")
    }
}