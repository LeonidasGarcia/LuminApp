package com.luminteam.lumin.ui.screens.settings

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.data.repository.LocalVibrationManager
import com.luminteam.lumin.ui.components.LuminButtonAlt
import com.luminteam.lumin.ui.components.LuminContentThemeButtonDefaults
import com.luminteam.lumin.ui.components.LuminModal
import com.luminteam.lumin.ui.components.Separator
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.screens.settings.components.SwitchOption
import com.luminteam.lumin.ui.screens.settings.components.Option
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminRed
import com.luminteam.lumin.ui.viewmodels.SettingsViewModel
import kotlinx.serialization.Serializable
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Serializable
data object SettingsScreen : NavKey

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val context = LocalContext.current
    val vibrator = LocalVibrationManager.current

    val formattedTime = remember(state.dailyReminderTime) {
        try {
            val parsedTime = LocalTime.parse(state.dailyReminderTime)
            parsedTime.format(DateTimeFormatter.ofPattern("hh:mm a"))
        } catch (e: Exception) {
            "--:--"
        }
    }

    var isShown by remember { mutableStateOf(false) }


    fun vibrate() {
        if (state.isVibrationOn) {
            vibrator.vibrate()
        }
    }

    fun showTimePicker() {
        val current = try {
            LocalTime.parse(state.dailyReminderTime)
        } catch (e: Exception) {
            LocalTime.of(20, 0)
        }

        TimePickerDialog(
            context,
            { _, hour, minute ->
                viewModel.setDailyReminderTime(hour, minute)
            },
            current.hour,
            current.minute,
            false
        ).show()
    }

    LuminModal(
        isShown = isShown,
        title = "¿Eliminar cuenta?",
        description = "Perderás todo tu progreso, racha y logros. Esta acción no se puede deshacer.",
        confirmText = "Si. Eliminar",
        cancelText = "No. Cancelar",
        onDismissRequest = { isShown = false },
        onConfirm = { /* Aca borras la cuenta :v */ }
    )

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TitleText(text = "Aplicación")
        }
        item {
            SwitchOption(
                text = "Efectos de sonido",
                isActived = state.isSfxOn,
                onClick = { viewModel.toggleSfx(it) }
            )
        }
        item {
            SwitchOption(
                text = "Vibración",
                isActived = state.isVibrationOn,
                onClick = { viewModel.toggleVibration(it) }
            )
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
                contentTheme = LuminContentThemeButtonDefaults.dark,
                onClick = {
                    vibrate()
                },
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Notificaciones")
        }
        item {
            SwitchOption(
                text = "Recordatorio diario",
                isActived = state.isDailyReminderOn,
                onClick = { viewModel.toggleDailyReminder(it) }
            )
        }
        item {
            Option(
                text = "Hora de recordatorio",
                valueText = formattedTime,
                onClick = { if (state.isDailyReminderOn) showTimePicker() else Unit },
                valueIcon = R.drawable.clock_icon,
                valueColor = if (state.isDailyReminderOn) LuminCyan else LuminLightGray,
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Acerca de")
        }
        item {
            Option(
                text = "Términos de servicio",
                isExternal = true,
                valueIcon = R.drawable.external_icon,
            )
        }
        item {
            Option(
                text = "Política de privacidad",
                isExternal = true,
                valueIcon = R.drawable.external_icon
            )
        }
        item {
            Option(
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
                color = LuminRed,
                onClick = {
                    vibrate()
                    isShown = true
                },
            )
        }
    }
}