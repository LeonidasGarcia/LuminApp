package com.example.lumin.ui.screens.login.components

import androidx.compose.foundation.layout.width
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
import com.example.lumin.ui.theme.LuminSoftGray
import com.example.lumin.ui.theme.LuminTheme
import com.example.lumin.ui.theme.LuminVerySoftGray
import com.example.lumin.ui.theme.LuminWhite

@Composable
fun LoginTerms(
    modifier: Modifier = Modifier
) {
    Text(
        text = buildAnnotatedString {
            append("Al continuar, aceptas nuestros ")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold, color = LuminWhite
                )
            ) {
                append(text = "Términos de Servicio ")
            }
            append("y ")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold, color = LuminWhite
                )
            ) {
                append(text = "Política de Privacidad")
            }
            append(".")
        },
        modifier = Modifier.width(260.dp),
        fontSize = 12.sp,
        lineHeight = 17.sp,
        color = LuminVerySoftGray,
        textAlign = TextAlign.Center
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818
)
@Composable
fun LoginTermsPreview() {
    LuminTheme {
        LoginTerms()
    }
}