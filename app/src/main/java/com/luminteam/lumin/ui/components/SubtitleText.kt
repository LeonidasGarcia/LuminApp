package com.luminteam.lumin.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun SubtitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = LuminWhite,
    isExternal: Boolean = false
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 20.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight.Bold,
            color = color,
            textDecoration = if (isExternal) TextDecoration.Underline else TextDecoration.None,
        )
    )
}