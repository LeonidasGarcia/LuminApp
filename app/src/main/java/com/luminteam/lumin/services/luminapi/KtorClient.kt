package com.luminteam.lumin.services.luminapi

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClientFactory {
    fun createClient(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true // Ignora campos que no estén en tu clase de datos
                    prettyPrint = true
                    isLenient = true
                })
            }

            defaultRequest {
                url("http://10.0.2.2:8000/") // Establecer una URL base
            }
        }
    }
}