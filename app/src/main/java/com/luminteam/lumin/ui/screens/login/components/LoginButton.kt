package com.luminteam.lumin.ui.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminSoftGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

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
        Row {
            GoogleLogo()
            Spacer(modifier.width(8.dp))
            GoogleText()
        }
    }
}

@Composable
fun GoogleText() {
    Text(text ="Continuar con Google",
        color = LuminSoftGray
    )
}

@Composable
fun GoogleLogo() {
    Image(
        painter = painterResource(id = R.drawable.google_logo),
        contentDescription = "Google Logo",
        modifier = Modifier.height(20.dp)
    )
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