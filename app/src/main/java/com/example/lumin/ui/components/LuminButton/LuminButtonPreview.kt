package com.example.lumin.ui.components.LuminButton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumin.ui.theme.LuminBlack
import com.example.lumin.ui.theme.LuminCyan
import com.example.lumin.ui.theme.LuminTheme

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LuminContinueButton() {
    LuminTheme {
        LuminButton(
            title = "Continuar",
            buttonColor = LuminCyan
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(text = "Nivel: Básico", fontSize = 12.sp)
                Text(text = "Sección: Variables y Salidas", fontSize = 12.sp)
            }
        }
    }
}