package com.luminteam.lumin.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun MainHeader() {
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
}