package com.example.lumin.ui.screens.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumin.ui.theme.LuminCyan
import com.example.lumin.ui.theme.LuminSoftGray
import com.example.lumin.ui.theme.LuminTheme
import com.example.lumin.ui.theme.LuminVerySoftGray
import com.example.lumin.ui.theme.LuminWhite

@Composable
fun LoginHeader(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Icon
        Text(
            text = buildAnnotatedString {
                append(text = "Bienvenido a ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold, color = LuminCyan
                    )
                ) {
                    append(text = "Lumin")
                }
            },
            color = LuminWhite,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = buildAnnotatedString {
                append(text = "aprende, ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = LuminCyan)) {
                    append(text = "de verdad ")
                }
                append(text = ", a tu manera")
            },
            color = LuminVerySoftGray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818
)
@Composable
fun LoginHeaderPreview() {
    LuminTheme {
        LoginHeader()
    }
}