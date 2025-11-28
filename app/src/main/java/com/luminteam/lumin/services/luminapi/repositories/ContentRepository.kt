package com.luminteam.lumin.services.luminapi.repositories

import com.luminteam.lumin.services.luminapi.KtorClientFactory
import com.luminteam.lumin.services.luminapi.dto.ContentResponse
import com.luminteam.lumin.services.luminapi.interfaces.Content
import com.luminteam.lumin.services.luminapi.interfaces.User
import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.LevelData
import com.luminteam.lumin.ui.domain.LevelDataUiState
import com.luminteam.lumin.ui.domain.PageData
import com.luminteam.lumin.ui.domain.SectionData
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header

class ContentRepository(private val client: HttpClient) : Content {
    override suspend fun getContent(jwt: String): ContentResponse {
        val response = client.get("/api/content/complete_structure") {
            header("Authorization", "Bearer $jwt")
        }

        return response.body<ContentResponse>()
    }
}

val contentRepository = ContentRepository(KtorClientFactory.createClient())