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
import com.luminteam.lumin.ui.theme.LuminAltGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminVerySoftGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun LockedSectionButton(title: String, description: String) {
    LuminButton(
        title = title,
        titleColor = LuminWhite,
        buttonColor = LuminAltGray,
        icon = R.drawable.lock_icon,
        iconColor = LuminWhite,
        modifier = Modifier.padding(10.dp)
    ) {
        Column {
            Text(text = description, color = LuminVerySoftGray)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LockedSectionButtonPreview() {
    LuminTheme {
        LockedSectionButton(title = "Sección 1", description = "Variables y Salidas")
    }
}