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

    val profilePhotoUri: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferenceKeys.PROFILE_PHOTO_URI] ?: ""
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

    suspend fun saveProfilePhotoUri(value: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.PROFILE_PHOTO_URI] = value
        }
    }

    suspend fun deleteProfilePhotoUri() {
        context.dataStore.edit { preferences ->
            preferences.remove(PreferenceKeys.PROFILE_PHOTO_URI)
        }
    }
}

val LocalLoginRepository = staticCompositionLocalOf<LoginRepository> {
    error("LoginRepository no ha sido provisto en el MainActivity")
}