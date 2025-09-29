package com.example.lumin.ui.screens.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lumin.ui.theme.LuminCyan
import com.example.lumin.ui.theme.LuminSoftGray
import com.example.lumin.ui.theme.LuminTheme

@Composable
fun LoginButton(
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = LuminCyan
        ),
        modifier = Modifier.width(300.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text("Iniciar Sesión con Google", color = LuminSoftGray)
    }
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