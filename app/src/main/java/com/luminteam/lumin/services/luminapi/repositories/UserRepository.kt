package com.luminteam.lumin.services.luminapi.repositories

import com.luminteam.lumin.services.luminapi.KtorClientFactory
import com.luminteam.lumin.services.luminapi.dto.AuthCode
import com.luminteam.lumin.services.luminapi.dto.LoginResult
import com.luminteam.lumin.services.luminapi.interfaces.Auth
import com.luminteam.lumin.services.luminapi.interfaces.User
import com.luminteam.lumin.ui.domain.Calification
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

class UserRepository(private val client: HttpClient) : User {
    override suspend fun getUserData(jwt: String): UserDataUiState {
        val response = client.get("/user/data") {
            header("Authorization", "Bearer $jwt")
        }

        return response.body<UserDataUiState>()
    }

    override suspend fun getUserMetrics(jwt: String): UserMetricsDataUiState {
        val response = client.get("/user/metrics") {
            header("Authorization", "Bearer $jwt")
        }

        return response.body<UserMetricsDataUiState>()
    }

    override suspend fun getCalifications(jwt: String, id: Int): List<Calification> {
        val response = client.get("/user/qualifications?user_id=$id") {
            header("Authorization", "Bearer $jwt")
        }

        return response.body<List<Calification>>()
    }

    override suspend fun postCreateSubscription() {
        TODO("Not yet implemented")
    }
}

val userRepository = UserRepository(KtorClientFactory.createClient())