package com.example.lumin.ui.screens.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lumin.ui.theme.LuminCyan
import com.example.lumin.ui.theme.LuminSoftGray
import com.example.lumin.ui.theme.LuminTheme
import com.example.lumin.ui.theme.LuminWhite

@Composable
fun LoginButton(
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = LuminWhite
        ),
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        GoogleText()
    }
}

@Composable
fun GoogleText() {
    Text(buildAnnotatedString {
        append("Continuar con ")
        withStyle(style = SpanStyle(color = Color(0xFF4384f5))) {
            append("G")
        }
        withStyle(style = SpanStyle(color = Color(0xFFe94234))) {
            append("o")
        }
        withStyle(style = SpanStyle(color = Color(0xFFf9bc03))) {
            append("o")
        }
        withStyle(style = SpanStyle(color = Color(0xFF4384f5))) {
            append("g")
        }
        withStyle(style = SpanStyle(color = Color(0xFF36a955))) {
            append("l")
        }
        withStyle(style = SpanStyle(color = Color(0xFFe94234))) {
            append("e")
        }
    }, color = LuminSoftGray)
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818
)
@Composable
fun LoginButtonPreview() {
    LuminTheme {
        LoginButton()
    }
}