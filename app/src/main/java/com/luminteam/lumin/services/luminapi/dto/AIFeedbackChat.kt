package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class AIFeedbackChatRequest(
    val req: ReqFeedback,
    val body: MessageBodyFeedback
)

@Serializable
data class ReqFeedback(
    val contextData: ContextData,
    val userData: UserDataFeedback,
    val questions: List<QuestionResponse>,
    val answers: List<AnswerRequest>
)

@Serializable
data class UserDataFeedback(
    val username: String,
    val age: Int
)

@Serializable
data class MessageBodyFeedback(
    val mensaje: String,
    val thread_id: String
)

@Serializable
data class AIFeedbackChatResponse(
    val text: String,
    val type: String,
    val thread_id: String
)