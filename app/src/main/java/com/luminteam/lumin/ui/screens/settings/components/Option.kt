package com.luminteam.lumin.ui.screens.settings.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun Option(
    modifier: Modifier = Modifier,
    text: String = "Nombre de opción",
    valueText: String = "",
    valueIcon: Int = 0,
    valueColor: Color = LuminWhite,
    isExternal: Boolean = false,
    onClick: () -> Unit = {print("Hola")},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        SubtitleText(
            text = text,
            isExternal = isExternal
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .clickable(onClick = onClick)
        ) {
            if (valueIcon != 0) {
                Icon(
                    painter = painterResource(id = valueIcon),
                    tint = valueColor,
                    contentDescription = null,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp),
                )
            }
            if (valueText.isNotEmpty()) {
                SubtitleText(
                    text = valueText,
                    color = valueColor,
                )
            }
        }
    }
}

@Preview
@Composable
fun SpecialOptionPreview(
    modifier: Modifier = Modifier
) {
    Option(
        text = "Hora de recordatorio",
        valueText = "8:00pm",
        valueIcon = R.drawable.clock_icon,
        valueColor = LuminCyan
    )
}