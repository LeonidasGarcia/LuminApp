package com.luminteam.lumin.ui.viewmodels

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalTime

// En el futuro tiene que heredar AndroidViewModel
class SettingsViewModel : ViewModel() {
    private val _SFX_ON = MutableStateFlow<Boolean>(true)
    val SFX_ON: StateFlow<Boolean> = _SFX_ON.asStateFlow()

    private val _VIBRATION_ON = MutableStateFlow<Boolean>(true)
    val VIBRATION_ON: StateFlow<Boolean> = _VIBRATION_ON.asStateFlow()

    private val _DAILY_REMINDER_ON = MutableStateFlow<Boolean>(true)
    val DAILY_REMINDER_ON: StateFlow<Boolean> = _DAILY_REMINDER_ON.asStateFlow()

    private val _DAILY_REMINDER_TIME = MutableStateFlow<LocalTime>(LocalTime.of(20, 0))
    val DAILY_REMINDER_TIME: StateFlow<LocalTime> = _DAILY_REMINDER_TIME.asStateFlow()
}