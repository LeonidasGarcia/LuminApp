package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.services.luminapi.dto.AITutorChatRequest
import com.luminteam.lumin.services.luminapi.dto.AITutorChatResponse

interface TutorChat {
    suspend fun sendMessage(
        jwt: String,
        aiTutorChatRequest: AITutorChatRequest
    ): AITutorChatResponse
}