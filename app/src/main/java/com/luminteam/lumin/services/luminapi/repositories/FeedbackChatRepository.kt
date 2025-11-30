package com.luminteam.lumin.services.luminapi.repositories

import com.luminteam.lumin.services.luminapi.KtorClientFactory
import com.luminteam.lumin.services.luminapi.dto.AIFeedbackChatRequest
import com.luminteam.lumin.services.luminapi.dto.AIFeedbackChatResponse
import com.luminteam.lumin.services.luminapi.dto.AITutorChatRequest
import com.luminteam.lumin.services.luminapi.dto.AITutorChatResponse
import com.luminteam.lumin.services.luminapi.interfaces.FeedbackChat
import com.luminteam.lumin.services.luminapi.interfaces.TutorChat
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class FeedbackChatRepository(private val client: HttpClient) : FeedbackChat {
    override suspend fun sendMessage(
        jwt: String,
        aiFeedbackChatRequest: AIFeedbackChatRequest
    ): AIFeedbackChatResponse {
        val response = client.post("agente/feedback") {
            header("Authorization", "Bearer $jwt")
            contentType(ContentType.Application.Json)
            setBody(aiFeedbackChatRequest)
        }

        val chatResult = response.body<AIFeedbackChatResponse>()
        return chatResult
    }
}

val feedBackChatRepository = FeedbackChatRepository(KtorClientFactory.createClient())