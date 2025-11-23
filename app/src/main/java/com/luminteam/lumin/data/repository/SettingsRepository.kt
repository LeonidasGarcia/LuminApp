package com.luminteam.lumin.data.repository

import android.content.Context
import android.os.VibratorManager
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.luminteam.lumin.util.alarm.AlarmScheduler
import com.luminteam.lumin.util.sound.SoundManager
import com.luminteam.lumin.util.vibration.VibrationManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsRepository(private val context: Context) {
    companion object {
        val SFX_ON = booleanPreferencesKey("sfx_on")
        val VIBRATION_ON = booleanPreferencesKey("vibration_on")
        val DAILY_REMINDER_ON = booleanPreferencesKey("daily_reminder_on")
        val DAILY_REMINDER_TIME = stringPreferencesKey("daily_reminder_time")
        val JWT = stringPreferencesKey("jwt")
    }

    val isSfxOn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[SFX_ON] ?: true
    }

    val isVibrationOn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[VIBRATION_ON] ?: true
    }

    val isDailyReminderOn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[DAILY_REMINDER_ON] ?: true
    }

    val dailyReminderTime: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[DAILY_REMINDER_TIME] ?: "20:00"
    }

    val jwt: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[JWT] ?: ""
    }

    suspend fun saveSfx(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[SFX_ON] = value
        }
    }

    suspend fun saveVibration(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[VIBRATION_ON] = value
        }
    }

    suspend fun saveDailyReminder(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DAILY_REMINDER_ON] = value
        }
    }

    suspend fun saveDailyReminderTime(value: String) {
        context.dataStore.edit { preferences ->
            preferences[DAILY_REMINDER_TIME] = value
        }
    }

    suspend fun saveJWT(value: String) {
        context.dataStore.edit { preferences ->
            preferences[JWT] = value
        }
    }

    suspend fun deleteJWT() {
        context.dataStore.edit { preferences ->
            preferences.remove(JWT)
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