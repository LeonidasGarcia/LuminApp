package com.luminteam.lumin.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray

@Composable
fun ContinueButton() {
    LuminButton(
        title = "Continuar",
        titleColor = LuminBlack,
        buttonColor = LuminCyan,
        icon = R.drawable.arrow_icon,
        iconColor = LuminBlack,
        modifier = Modifier.padding(10.dp),
        rounded = 15.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(text = "Nivel: Básico", color = LuminDarkGray, fontSize = 12.sp)
            Text(text = "Sección: Variables y Salidas", color = LuminDarkGray, fontSize = 12.sp)
        }
    }
}