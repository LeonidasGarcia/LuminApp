package com.luminteam.lumin.services.luminapi

import com.luminteam.lumin.services.luminapi.dto.AnswerRequest
import com.luminteam.lumin.services.luminapi.dto.CompleteTheCodeAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.CompleteTheCodeResponse
import com.luminteam.lumin.services.luminapi.dto.FixTheCodeAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.FixTheCodeResponse
import com.luminteam.lumin.services.luminapi.dto.FreeResponseAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.FreeResponseResponse
import com.luminteam.lumin.services.luminapi.dto.QuestionResponse
import com.luminteam.lumin.services.luminapi.dto.SingleSelectionAnswerRequest
import com.luminteam.lumin.services.luminapi.dto.SingleSelectionResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.ApplicationResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.PolymorphicModuleBuilder
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus

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

val practiceResultsModule by lazy {
    SerializersModule {
        polymorphic(AnswerRequest::class) {
            subclass(
                SingleSelectionAnswerRequest::class,
                SingleSelectionAnswerRequest.serializer()
            )
            subclass(FreeResponseAnswerRequest::class, FreeResponseAnswerRequest.serializer())
            subclass(FixTheCodeAnswerRequest::class, FixTheCodeAnswerRequest.serializer())
            subclass(CompleteTheCodeAnswerRequest::class, CompleteTheCodeAnswerRequest.serializer())
        }
    }
}

val modules = practiceModule.plus(practiceResultsModule)

class ForbiddenException(message: String) : Exception(message)

object KtorClientFactory {
    fun createClient(): HttpClient {
        return HttpClient(CIO) {

            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.BODY
            }

            install(ContentNegotiation) {
                json(Json {
                    serializersModule = modules
                    ignoreUnknownKeys = true // Ignora campos que no estén en tu clase de datos
                    prettyPrint = true
                    isLenient = true
                })
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 60000
                connectTimeoutMillis = 5000
            }

            defaultRequest {
                url("https://container-lumin.jollywater-7985bce0.eastus2.azurecontainerapps.io/") // Establecer una URL base
            }
        }
    }
}