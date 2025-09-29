package com.example.lumin.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lumin.ui.screens.login.components.LoginButton
import com.example.lumin.ui.screens.login.components.LoginHeader
import com.example.lumin.ui.screens.login.components.LoginImageHeader
import com.example.lumin.ui.screens.login.components.LoginTerms
import com.example.lumin.ui.theme.LuminIntenseGray
import com.example.lumin.ui.theme.LuminTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(LuminIntenseGray)
            .fillMaxSize()
    ) {
        LoginHeader()
        Spacer(modifier = Modifier.height(28.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginButton()
            Spacer(modifier = Modifier.height(12.dp))
            LoginTerms()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LoginScreenPreview() {
    LuminTheme {
        LoginScreen()
    }
}