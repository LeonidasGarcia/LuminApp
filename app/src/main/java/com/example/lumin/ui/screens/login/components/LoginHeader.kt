package com.example.lumin.ui.screens.login.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumin.R
import com.example.lumin.ui.theme.Inter
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
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginImageHeader()
        Text(
            text = buildAnnotatedString {
                append(text = "Bienvenido a Lumin")
            },
            color = LuminWhite,
            fontSize = 24.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Aprende de verdad a tu manera.",
            color = LuminVerySoftGray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoginImageHeader(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.lumin_logo),
        contentDescription = "Logo Lumin",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
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