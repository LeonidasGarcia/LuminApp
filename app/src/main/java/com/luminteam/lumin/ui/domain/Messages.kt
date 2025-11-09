package com.luminteam.lumin.ui.domain

data class ChatMessage(
    val text: String,
    val type: ChatMessageType
)

enum class ChatMessageType {
    USER,
    AGENT
}