package com.luminteam.lumin.services.luminapi.repositories

import com.luminteam.lumin.services.luminapi.KtorClientFactory
import com.luminteam.lumin.services.luminapi.dto.AuthCode
import com.luminteam.lumin.services.luminapi.dto.ContentResponse
import com.luminteam.lumin.services.luminapi.dto.ContextDataRequest
import com.luminteam.lumin.services.luminapi.dto.LoginResult
import com.luminteam.lumin.services.luminapi.dto.PracticeResponse
import com.luminteam.lumin.services.luminapi.dto.practiceResultsRequest
import com.luminteam.lumin.services.luminapi.interfaces.AI
import com.luminteam.lumin.services.luminapi.interfaces.Content
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AIRepository(private val client: HttpClient) : AI {
    override suspend fun postPractice(
        jwt: String,
        contextData: ContextDataRequest
    ): PracticeResponse {
        val response = client.post("agente/practice") {
            header("Authorization", "Bearer $jwt")
            contentType(ContentType.Application.Json)
            setBody(contextData)
        }

        val practiceResponse = response.body<PracticeResponse>()
        return practiceResponse
    }

    override suspend fun postPracticeResults(
        jwt: String,
        practiceResults: practiceResultsRequest
    ) {
        TODO("Not yet implemented")
    }
}

val aIRepository = AIRepository(KtorClientFactory.createClient())