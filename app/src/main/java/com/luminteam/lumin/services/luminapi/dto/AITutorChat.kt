package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class AITutorChatRequest(
    val req: ReqTutor,
    val body: MessageBodyTutor
)

@Serializable
data class ReqTutor(
    val contextData: ContextData,
    val userData: UserDataTutor,
)

@Serializable
data class UserDataTutor(
    val username: String,
    val age: Int
)

@Serializable
data class MessageBodyTutor(
    val mensaje: String,
    val thread_id: String
)

@Serializable
data class AITutorChatResponse(
    val text: String,
    val type: String,
    val thread_id: String
)