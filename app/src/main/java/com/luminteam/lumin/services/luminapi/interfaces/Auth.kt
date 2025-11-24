package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.services.luminapi.dto.AuthCode
import com.luminteam.lumin.services.luminapi.dto.LoginResult
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState

interface Auth {
    // obtención de jwt
    suspend fun postGoogleLogin(authCode: AuthCode): LoginResult

}