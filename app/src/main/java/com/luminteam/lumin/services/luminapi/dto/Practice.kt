package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
data class PracticeResponse(
    val questions: List<QuestionResponse>
)

@Serializable
@JsonClassDiscriminator("type")
sealed interface QuestionResponse {
    val id: Int;
}

@Serializable
@SerialName("SINGLESELECTION")
data class SingleSelectionResponse(
    override val id: Int,
    val question: String,
    val options: List<String>,
    val description: String
) : QuestionResponse

@Serializable
@SerialName("FREERESPONSE")
data class FreeResponseResponse(
    override val id: Int,
    val question: String,
    val description: String
) : QuestionResponse

@Serializable
@SerialName("FIXTHECODE")
data class FixTheCodeResponse(
    override val id: Int,
    val wrongCode: String,
    val description: String
) : QuestionResponse

@Serializable
@SerialName("COMPLETETHECODE")
data class CompleteTheCodeResponse(
    override val id: Int,
    val codeLines: List<LineResponse>,
    val missingTokens: List<String>,
    val description: String
) : QuestionResponse

@Serializable
data class LineResponse(
    val tokens: List<TokenResponse>
)

@Serializable
data class TokenResponse(
    val token: String
)