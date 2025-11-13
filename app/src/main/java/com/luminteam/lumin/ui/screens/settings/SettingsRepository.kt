package com.luminteam.lumin.ui.screens.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsRepository(private val context: Context) {
    companion object {
        val SFX_ON = booleanPreferencesKey("sfx_on")
        val VIBRATION_ON = booleanPreferencesKey("vibration_on")
        val DAILY_REMINDER_ON = booleanPreferencesKey("daily_reminder_on")
        val DAILY_REMINDER_TIME = booleanPreferencesKey("dialy_reminder_time")
    }
}