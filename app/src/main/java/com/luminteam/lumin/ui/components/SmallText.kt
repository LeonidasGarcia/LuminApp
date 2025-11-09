package com.luminteam.lumin.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminLightGray

@Composable
fun SmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = LuminLightGray,
    isBold: Boolean = false,
    isUnderlined: Boolean = false,
    isCentered: Boolean = false
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 15.sp,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Medium,
            color = color,
            textDecoration = if (isUnderlined) TextDecoration.Underline else TextDecoration.None,
            textAlign = if (isCentered) TextAlign.Center else TextAlign.Unspecified
        )
    )
}