package com.luminteam.lumin.ui.screens.home.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.components.LuminButtonAlt
import com.luminteam.lumin.ui.components.LuminContinueButton
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.Separator
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.screens.home.main.components.MainHeader
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminWhite
import kotlinx.serialization.Serializable

@Serializable
data object MainScreen : NavKey

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TitleText(
                text = "Bienvenido a Lumin",
            )
        }
        item {
            ParagraphText(
                text = "El lugar ideal para comenzar en el grandioso mundo de la programación. Con perseverencia y esfuerzo te convertirás en un gran programador. ¡Lumin se encargará del resto!",
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "¿Qué deseas hacer?")
        }
        item {
            LuminButtonAlt(
                title = "Seguir estudiando",
                description = "Básico: Variables y Salidas",
                icon = R.drawable.next_arrow_icon
            )
        }
        item {
            LuminButtonAlt(
                title = "Reto diario",
                description = "¡Ponte a prueba!",
                color = LuminOrange,
                icon = R.drawable.brain_icon
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Sabías que...")
        }
        item {
            ParagraphText(text = "El lenguaje de programación Python lleva ese nombre directamente en honor al grupo de comedia británico Monty Python.")
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