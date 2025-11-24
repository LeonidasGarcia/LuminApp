package com.luminteam.lumin.services.luminapi.repositories

import com.luminteam.lumin.data.repository.SettingsRepository
import com.luminteam.lumin.services.luminapi.KtorClientFactory
import com.luminteam.lumin.services.luminapi.dto.AuthCode
import com.luminteam.lumin.services.luminapi.dto.LoginResult
import com.luminteam.lumin.services.luminapi.interfaces.Auth
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthRepository(private val client: HttpClient) : Auth {
    override suspend fun postGoogleLogin(authCode: AuthCode): LoginResult {
        val response = client.post("auth/google") {
            contentType(ContentType.Application.Json)
            setBody(authCode)
        }

        val loginResult = response.body<LoginResult>()
        return loginResult
    }
}

val authRepository = AuthRepository(KtorClientFactory.createClient())