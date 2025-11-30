package com.luminteam.lumin.ui.screens.learn.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.services.luminapi.dto.AITutorChatRequest
import com.luminteam.lumin.services.luminapi.dto.ContextData
import com.luminteam.lumin.services.luminapi.dto.MessageBodyTutor
import com.luminteam.lumin.services.luminapi.dto.ReqTutor
import com.luminteam.lumin.services.luminapi.dto.UserData
import com.luminteam.lumin.services.luminapi.dto.UserDataTutor
import com.luminteam.lumin.ui.components.LuminChat
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.viewmodels.AIChatViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable

@Serializable
data object AiChatScreen : NavKey

@Composable
fun AiChatScreen(
    userViewModel: UserViewModel,
    aiChatViewModel: AIChatViewModel,
    levelName: String,
    sectionName: String
) {
    val messages = aiChatViewModel.messages.collectAsStateWithLifecycle().value

    val thread_id = aiChatViewModel.thread_id.collectAsStateWithLifecycle().value

    val username = userViewModel.currentUserData.collectAsStateWithLifecycle().value.username
    val age = userViewModel.currentUserData.collectAsStateWithLifecycle().value.age

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        TitleText(
            text = "Aclara tus dudas"
        )
        LuminChat(
            modifier = Modifier.weight(1f),
            messages = messages,
            onSend = {
                val aiTutorChatRequest = AITutorChatRequest(
                    req = ReqTutor(
                        contextData = ContextData(
                            levelName = levelName,
                            sectionName = sectionName
                        ),
                        userData = UserDataTutor(
                            username = username,
                            age = age
                        )
                    ),
                    body = MessageBodyTutor(
                        mensaje = it,
                        thread_id = thread_id
                    )
                )

                aiChatViewModel.addTutorUserMessage(aiTutorChatRequest)
            }
        )
    }
}