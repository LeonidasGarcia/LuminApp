package com.luminteam.lumin.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.ui.screens.login.components.LoginButton
import com.luminteam.lumin.ui.screens.login.components.LoginHeader
import com.luminteam.lumin.ui.screens.login.components.LoginTerms
import com.luminteam.lumin.ui.theme.LuminIntenseGray
import com.luminteam.lumin.ui.theme.LuminTheme

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