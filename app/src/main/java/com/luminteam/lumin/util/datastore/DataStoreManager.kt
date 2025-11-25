package com.luminteam.lumin.util.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_preferences")

object PreferenceKeys {
    // La configuracion
    val SFX_ON = booleanPreferencesKey("sfx_on")
    val VIBRATION_ON = booleanPreferencesKey("vibration_on")
    val DAILY_REMINDER_ON = booleanPreferencesKey("daily_reminder_on")
    val DAILY_REMINDER_TIME = stringPreferencesKey("daily_reminder_time")

    // Otras cosas
    val JWT = stringPreferencesKey("jwt")
}