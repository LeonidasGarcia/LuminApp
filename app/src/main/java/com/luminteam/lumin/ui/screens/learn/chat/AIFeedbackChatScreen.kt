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
import com.luminteam.lumin.services.luminapi.dto.AIFeedbackChatRequest
import com.luminteam.lumin.services.luminapi.dto.AITutorChatRequest
import com.luminteam.lumin.services.luminapi.dto.AnswerRequest
import com.luminteam.lumin.services.luminapi.dto.ContextData
import com.luminteam.lumin.services.luminapi.dto.MessageBodyFeedback
import com.luminteam.lumin.services.luminapi.dto.MessageBodyTutor
import com.luminteam.lumin.services.luminapi.dto.QuestionResponse
import com.luminteam.lumin.services.luminapi.dto.ReqFeedback
import com.luminteam.lumin.services.luminapi.dto.ReqTutor
import com.luminteam.lumin.services.luminapi.dto.UserDataFeedback
import com.luminteam.lumin.services.luminapi.dto.UserDataTutor
import com.luminteam.lumin.ui.components.LuminChat
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.viewmodels.AIChatViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable

@Serializable
data object AiFeedbackChatScreen : NavKey

@Composable
fun AiFeedbackChatScreen(
    userViewModel: UserViewModel,
    aiChatViewModel: AIChatViewModel,
    viewModel: LevelNavigationViewModel,
    levelName: String,
    sectionName: String,
    questions: List<QuestionResponse>,
    answers: List<AnswerRequest>
) {
    val messages = aiChatViewModel.messages.collectAsStateWithLifecycle().value

    val thread_id = aiChatViewModel.thread_id.collectAsStateWithLifecycle().value

    val username = userViewModel.currentUserData.collectAsStateWithLifecycle().value.username
    val age = userViewModel.currentUserData.collectAsStateWithLifecycle().value.age

    LaunchedEffect(Unit) {
        val aiFeedbackChatRequest = AIFeedbackChatRequest(
            req = ReqFeedback(
                contextData = ContextData(
                    levelName = levelName,
                    sectionName = sectionName
                ),
                userData = UserDataFeedback(
                    username = username,
                    age = age
                ),
                questions = questions,
                answers = answers
            ),
            body = MessageBodyFeedback(
                mensaje = "",
                thread_id = thread_id
            )
        )

        aiChatViewModel.fetchFeedbackMessage(aiFeedbackChatRequest = aiFeedbackChatRequest)
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
                val aiFeedbackChatRequest = AIFeedbackChatRequest(
                    req = ReqFeedback(
                        contextData = ContextData(
                            levelName = levelName,
                            sectionName = sectionName
                        ),
                        userData = UserDataFeedback(
                            username = username,
                            age = age
                        ),
                        questions = questions,
                        answers = answers
                    ),
                    body = MessageBodyFeedback(
                        mensaje = it,
                        thread_id = thread_id
                    )
                )

                aiChatViewModel.addFeedbackUserMessage(aiFeedbackChatRequest = aiFeedbackChatRequest)
            }
        )
    }
}