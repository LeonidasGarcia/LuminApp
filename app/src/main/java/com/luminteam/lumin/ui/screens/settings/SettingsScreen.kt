package com.luminteam.lumin.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButtonAlt
import com.luminteam.lumin.ui.components.LuminContentThemeButtonDefaults
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.Separator
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.screens.home.main.components.MainHeader
import com.luminteam.lumin.ui.screens.settings.components.Option
import com.luminteam.lumin.ui.screens.settings.components.SpecialOption
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminRed
import com.luminteam.lumin.ui.theme.LuminTheme


@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TitleText(text = "Aplicación")
        }
        item {
            Option(text = "Tema oscuro")
        }
        item {
            Option(text = "Efectos de sonido")
        }
        item {
            Option(text = "Vibración")
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Cuenta")
        }
        item {
            LuminButtonAlt(
                title = "Cerrar sesión",
                description = "",
                color = LuminDarkGray,
                contentTheme = LuminContentThemeButtonDefaults.dark
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Notificaciones")
        }
        item {
            Option(text = "Recordatorio diario")
        }
        item {
            SpecialOption(
                text = "Hora de recordatorio",
                valueText = "8:00pm",
                valueIcon = R.drawable.clock_icon,
                valueColor = LuminCyan
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Acerca de")
        }
        item {
            SpecialOption(
                text = "Términos de servicio",
                isExternal = true,
                valueIcon = R.drawable.external_icon,
            )
        }
        item {
            SpecialOption(
                text = "Política de privacidad",
                isExternal = true,
                valueIcon = R.drawable.external_icon
            )
        }
        item {
            SpecialOption(
                text = "Versión de la aplicación",
                valueText = "v1.0.0"
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Zona de peligro")
        }
        item {
            LuminButtonAlt(
                title = "Eliminar cuenta",
                description = "",
                color = LuminRed
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun SettingsScreenPreview() {
    LuminTheme {
        SettingsScreen()
    }
}