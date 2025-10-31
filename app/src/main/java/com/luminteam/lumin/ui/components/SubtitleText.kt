package com.luminteam.lumin.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun SubtitleText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight.Bold,
            color = LuminWhite,
        )
    )
}