package com.luminteam.lumin.ui.screens.settings.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Preview
@Composable
fun SwitchOption(
    modifier: Modifier = Modifier,
    text: String = "Nombre de opción",
    isActived: Boolean = false,
    onClick: (Boolean) -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        SubtitleText(
            text = text,
            color = if (isActived) LuminWhite else LuminLightGray
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            modifier = Modifier.scale(0.75f),
            checked = isActived,
            onCheckedChange = onClick,
            colors = SwitchDefaults.colors(
                checkedThumbColor = LuminCyan,
                checkedTrackColor = LuminDarkGray,
                checkedBorderColor = Color.Transparent,
                uncheckedThumbColor = LuminLightGray,
                uncheckedTrackColor = LuminDarkGray,
                uncheckedBorderColor = Color.Transparent,
            ),
        )
    }
}

@Preview
@Composable
fun OptionPreview() {
    var isChecked by remember { mutableStateOf(false) }

    SwitchOption(
        isActived = isChecked,
        onClick = { newState ->
            isChecked = newState
        }
    )
}
