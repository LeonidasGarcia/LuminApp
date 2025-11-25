package com.luminteam.lumin.data.repository

import android.content.Context
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.datastore.preferences.core.edit
import com.luminteam.lumin.util.alarm.AlarmScheduler
import com.luminteam.lumin.util.datastore.PreferenceKeys
import com.luminteam.lumin.util.datastore.dataStore
import com.luminteam.lumin.util.sound.SoundManager
import com.luminteam.lumin.util.vibration.VibrationManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepository(private val context: Context) {

    val isSfxOn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferenceKeys.SFX_ON] ?: true
    }

    val isVibrationOn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferenceKeys.VIBRATION_ON] ?: true
    }

    val isDailyReminderOn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferenceKeys.DAILY_REMINDER_ON] ?: true
    }

    val dailyReminderTime: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferenceKeys.DAILY_REMINDER_TIME] ?: "20:00"
    }

    suspend fun saveSfx(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.SFX_ON] = value
        }
    }

    suspend fun saveVibration(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.VIBRATION_ON] = value
        }
    }

    suspend fun saveDailyReminder(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.DAILY_REMINDER_ON] = value
        }
    }

    suspend fun saveDailyReminderTime(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.DAILY_REMINDER_TIME] = value
        }
    }
}

val LocalSettingsRepository = staticCompositionLocalOf<SettingsRepository> {
    error("SettingsRepository no ha sido provisto en el MainActivity")
}

val LocalAlarmScheduler = staticCompositionLocalOf<AlarmScheduler> {
    error("AlarmScheduler no ha sido provisto en el MainActivity")
}

val LocalVibrationManager = staticCompositionLocalOf<VibrationManager> {
    error("VibrationManager no ha sido provisto en el MainActivity")
}

val LocalSoundManager = staticCompositionLocalOf<SoundManager> {
    error("SoundManager no ha sido provisto en el MainActivity")
}

data class AppConfig(
    val isSfxOn: Boolean = true,
)

val LocalAppConfig = staticCompositionLocalOf { AppConfig() }