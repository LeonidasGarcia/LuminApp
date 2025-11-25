package com.luminteam.lumin.data.repository

import android.content.Context
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.datastore.preferences.core.edit
import com.luminteam.lumin.util.datastore.PreferenceKeys
import com.luminteam.lumin.util.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoginRepository(
    private val context: Context
) {
    val jwt: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferenceKeys.JWT] ?: ""
    }

    suspend fun saveJWT(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.JWT] = value
        }
    }

    suspend fun deleteJWT() {
        context.dataStore.edit { preferences ->
            preferences.remove(PreferenceKeys.JWT)
        }
    }
}

val LocalLoginRepository = staticCompositionLocalOf<LoginRepository> {
    error("LoginRepository no ha sido provisto en el MainActivity")
}