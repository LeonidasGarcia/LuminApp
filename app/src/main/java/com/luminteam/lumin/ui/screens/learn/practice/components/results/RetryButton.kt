package com.luminteam.lumin.ui.screens.learn.practice.components.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun RetryButton() {
    LuminButton(
        title = "Reintentar",
        titleColor = LuminWhite,
        buttonColor = LuminDarkGray,
        icon = R.drawable.retry_icon,
        iconColor = LuminWhite,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "El tutor de IA te dará recomendaciones",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(160.dp),
                fontWeight = FontWeight.Medium,
                color = LuminLightGray
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun RetryButtonPreview() {
    LuminTheme {
        RetryButton()
    }
}