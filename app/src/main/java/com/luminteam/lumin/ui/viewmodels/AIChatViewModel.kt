package com.luminteam.lumin.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.luminteam.lumin.data.repository.LoginRepository
import com.luminteam.lumin.services.luminapi.dto.AIFeedbackChatRequest
import com.luminteam.lumin.services.luminapi.dto.AITutorChatRequest
import com.luminteam.lumin.services.luminapi.dto.AnswerRequest
import com.luminteam.lumin.services.luminapi.repositories.feedBackChatRepository
import com.luminteam.lumin.services.luminapi.repositories.tutorChatRepository
import com.luminteam.lumin.ui.domain.ChatMessage
import com.luminteam.lumin.ui.domain.ChatMessageType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AIChatViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    private val _thread_id = MutableStateFlow<String>("")

    val thread_id: StateFlow<String> = _thread_id.asStateFlow()

    private val _messages = MutableStateFlow<List<ChatMessage>>(listOf())
    var messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    fun addTutorUserMessage(aiTutorChatRequest: AITutorChatRequest) {
        _messages.update {
            it + ChatMessage(
                text = aiTutorChatRequest.body.mensaje,
                type = ChatMessageType.USER
            )
        }

        viewModelScope.launch {
            fetchTutorMessage(aiTutorChatRequest = aiTutorChatRequest)
        }
    }

    // for feedback chat
    suspend fun fetchTutorMessage(aiTutorChatRequest: AITutorChatRequest) {
        val jwt = loginRepository.jwt.first()

        val chatResult =
            tutorChatRepository.sendMessage(jwt = jwt, aiTutorChatRequest = aiTutorChatRequest)

        Log.d("revision", chatResult.toString())

        _thread_id.update {
            chatResult.thread_id
        }

        _messages.update {
            it + ChatMessage(
                text = chatResult.text,
                type = ChatMessageType.AGENT
            )
        }
    }

    fun addFeedbackUserMessage(aiFeedbackChatRequest: AIFeedbackChatRequest) {
        _messages.update {
            it + ChatMessage(
                text = aiFeedbackChatRequest.body.mensaje,
                type = ChatMessageType.USER
            )
        }

        viewModelScope.launch {
            fetchFeedbackMessage(aiFeedbackChatRequest = aiFeedbackChatRequest)
        }
    }

    // logic for send message to ai chat
    suspend fun fetchFeedbackMessage(aiFeedbackChatRequest: AIFeedbackChatRequest) {
        val jwt = loginRepository.jwt.first()

        val chatResult =
            feedBackChatRepository.sendMessage(
                jwt = jwt,
                aiFeedbackChatRequest = aiFeedbackChatRequest
            )

        Log.d("revision", chatResult.toString())

        _thread_id.update {
            chatResult.thread_id
        }

        _messages.update {
            it + ChatMessage(
                text = chatResult.text,
                type = ChatMessageType.AGENT
            )
        }
    }


    fun clearMessages() {
        Log.d("clear", "limpiando")

        _thread_id.update {
            ""
        }

        _messages.update {
            listOf()
        }
    }

    companion object {
        fun provideFactory(repository: LoginRepository): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    AIChatViewModel(repository)
                }
            }
    }
}