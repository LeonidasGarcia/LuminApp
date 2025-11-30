package com.luminteam.lumin.services.luminapi.repositories

import com.luminteam.lumin.services.luminapi.KtorClientFactory
import com.luminteam.lumin.services.luminapi.dto.AITutorChatRequest
import com.luminteam.lumin.services.luminapi.dto.AITutorChatResponse
import com.luminteam.lumin.services.luminapi.interfaces.TutorChat
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class TutorChatRepository(private val client: HttpClient) : TutorChat {
    override suspend fun sendMessage(
        jwt: String,
        aiTutorChatRequest: AITutorChatRequest
    ): AITutorChatResponse {
        val response = client.post("agente/tutor") {
            header("Authorization", "Bearer $jwt")
            contentType(ContentType.Application.Json)
            setBody(aiTutorChatRequest)
        }

        val chatResult = response.body<AITutorChatResponse>()
        return chatResult
    }
}

val tutorChatRepository = TutorChatRepository(KtorClientFactory.createClient())