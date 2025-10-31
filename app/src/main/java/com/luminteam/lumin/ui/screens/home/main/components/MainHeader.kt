package com.luminteam.lumin.ui.screens.home.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.TitleText

@Composable
fun MainHeader() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        TitleText(
            text = "Bienvenido a Lumin",
        )
        ParagraphText(
            text = "El lugar ideal para comenzar en el grandioso " +
                    "mundo de la programación. Con perseverencia y " +
                    "esfuerzo te convertirás en un gran programador. " +
                    "¡Lumin se encargará del resto!",
        )
    }
}