package com.luminteam.lumin.ui.screens.learn.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.ui.components.LuminChat
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.domain.ChatMessage
import com.luminteam.lumin.ui.domain.ChatMessageType
import com.luminteam.lumin.ui.viewmodels.AIChatViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object AiFeedbackChatScreen : NavKey

@Composable
fun AiFeedbackChatScreen(
    aiChatViewModel: AIChatViewModel,
    viewModel: LevelNavigationViewModel
) {
    val messages = aiChatViewModel.messages.collectAsStateWithLifecycle().value

    LaunchedEffect(true) {
        val answers = viewModel.getQuestionAnswers()
        aiChatViewModel.fetchFeedBackMessage(answers)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        TitleText(
            text = "Retroalimentación"
        )
        LuminChat(
            modifier = Modifier.weight(1f),
            messages = messages,
            onSend = {
                aiChatViewModel.addUserMessage(it)
            }
        )
    }
}