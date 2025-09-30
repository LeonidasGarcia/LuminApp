package com.luminteam.lumin.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminButton.LuminButton
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminSoftGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(36.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            Text(
                text = "Bienvenido a Lumin",
                color = LuminWhite,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "El lugar ideal para comenzar en el grandioso " +
                        "mundo de la programación. Con perseverencia y " +
                        "esfuerzo te convertirás en un gran programador, " +
                        "Lumin se encargará del resto :).",
                color = LuminWhite,
                fontSize = 16.sp
            )
        }
        LuminButton(
            title = "Continuar",
            titleColor = LuminBlack,
            buttonColor = LuminCyan
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(text = "Nivel: Básico", color = LuminSoftGray, fontSize = 12.sp)
                Text(text = "Sección: Variables y Salidas", color = LuminSoftGray, fontSize = 12.sp)
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(36.dp)) {
            Text(
                text = "Niveles", color = LuminWhite,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Column (verticalArrangement = Arrangement.spacedBy(24.dp)) {
                LuminButton(
                    title = "Básico",
                    titleColor = LuminBlack,
                    buttonColor = LuminCyan
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(text = "Lo fundamental", color = LuminSoftGray, fontSize = 12.sp)
                    }
                }
                LuminButton(
                    title = "Intermedio",
                    titleColor = LuminBlack,
                    buttonColor = LuminCyan
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(text = "Sube tu nivel", color = LuminSoftGray, fontSize = 12.sp)
                    }
                }
                LuminButton(
                    title = "Avanzado",
                    titleColor = LuminBlack,
                    buttonColor = LuminCyan
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(text = "Conviertete en un experto", color = LuminSoftGray, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun MainScreenPreview() {
    LuminTheme {
        MainScreen()
    }
}