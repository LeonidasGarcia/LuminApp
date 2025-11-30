package com.luminteam.lumin.services.luminapi.repositories

import com.luminteam.lumin.services.luminapi.KtorClientFactory
import com.luminteam.lumin.services.luminapi.dto.ContextDataRequest
import com.luminteam.lumin.services.luminapi.dto.DailyPracticeResultsRequest
import com.luminteam.lumin.services.luminapi.dto.DailyPracticeResultsResponse
import com.luminteam.lumin.services.luminapi.dto.PracticeResponse
import com.luminteam.lumin.services.luminapi.dto.PracticeResultsRequest
import com.luminteam.lumin.services.luminapi.dto.PracticeResultsResponse
import com.luminteam.lumin.services.luminapi.dto.Questions
import com.luminteam.lumin.services.luminapi.interfaces.AI
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess

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
        practiceResults: PracticeResultsRequest
    ): PracticeResultsResponse {
        val response = client.post("agente/practiceResults") {
            header("Authorization", "Bearer $jwt")
            contentType(ContentType.Application.Json)
            setBody(practiceResults)
        }

        val practiceResultsResponse = response.body<PracticeResultsResponse>()
        return practiceResultsResponse
    }

    override suspend fun postDailyPractice(jwt: String): Result<PracticeResponse> {
        try {
            val response = client.post("agente/dailyPractice") {
                header("Authorization", "Bearer $jwt")
                contentType(ContentType.Application.Json)
            }

            val practiceResponse = response.body<PracticeResponse>()
            return Result.success(practiceResponse)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun postDailyPracticeResults(
        jwt: String,
        dailyPracticeResults: DailyPracticeResultsRequest
    ): DailyPracticeResultsResponse {
        val response = client.post("agente/dailyPracticeResults") {
            header("Authorization", "Bearer $jwt")
            contentType(ContentType.Application.Json)
            setBody(dailyPracticeResults)
        }

        val practiceResultsResponse = response.body<DailyPracticeResultsResponse>()
        return practiceResultsResponse
    }
}

val aIRepository = AIRepository(KtorClientFactory.createClient())