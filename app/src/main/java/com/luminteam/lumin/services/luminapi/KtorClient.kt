package com.luminteam.lumin.services.luminapi

import com.luminteam.lumin.services.luminapi.dto.CompleteTheCodeResponse
import com.luminteam.lumin.services.luminapi.dto.FixTheCodeResponse
import com.luminteam.lumin.services.luminapi.dto.FreeResponseResponse
import com.luminteam.lumin.services.luminapi.dto.QuestionResponse
import com.luminteam.lumin.services.luminapi.dto.SingleSelectionResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import kotlinx.serialization.modules.SerializersModule

val practiceModule by lazy {
    SerializersModule {
        polymorphic(QuestionResponse::class) {
            subclass(
                SingleSelectionResponse::class,
                SingleSelectionResponse.serializer()
            )
            subclass(FreeResponseResponse::class, FreeResponseResponse.serializer())
            subclass(FixTheCodeResponse::class, FixTheCodeResponse.serializer())
            subclass(CompleteTheCodeResponse::class, CompleteTheCodeResponse.serializer())
        }
    }
}

object KtorClientFactory {
    fun createClient(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    serializersModule = practiceModule
                    ignoreUnknownKeys = true // Ignora campos que no estén en tu clase de datos
                    prettyPrint = true
                    isLenient = true
                })
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 30000
                connectTimeoutMillis = 5000
            }

            defaultRequest {
                url("http://10.0.2.2:8000/") // Establecer una URL base
            }
        }
    }
}