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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.Roboto

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit = {}
) {
    Button(
        onClick = onLogin,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF2F2F2)
        ),
        modifier = Modifier
            .width(320.dp)
            .height(45.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Row {
            GoogleLogo()
            Spacer(modifier.width(10.dp))
            GoogleText()
        }
    }
}

@Composable
fun GoogleText() {
    Text(
        text = "Continuar con Google",
        color = LuminBlack,
        fontWeight = FontWeight.Medium,
        fontFamily = Roboto,
        fontSize = 16.sp
    )
}

@Composable
fun GoogleLogo() {
    Image(
        painter = painterResource(id = R.drawable.google_logo),
        contentDescription = "Google Logo",
        modifier = Modifier.height(19.dp)
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