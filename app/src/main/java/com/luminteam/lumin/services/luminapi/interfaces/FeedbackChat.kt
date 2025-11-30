package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.services.luminapi.dto.AIFeedbackChatRequest
import com.luminteam.lumin.services.luminapi.dto.AIFeedbackChatResponse

interface FeedbackChat {
    suspend fun sendMessage(
        jwt: String,
        aiFeedbackChatRequest: AIFeedbackChatRequest
    ): AIFeedbackChatResponse
}