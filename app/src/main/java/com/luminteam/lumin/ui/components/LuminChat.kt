package com.luminteam.lumin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.ui.domain.ChatMessage
import com.luminteam.lumin.ui.domain.ChatMessageType
import com.luminteam.lumin.ui.theme.LuminTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun LuminChat(
    modifier: Modifier,
    messages: List<ChatMessage>,
    onSend: (String) -> Unit
    // más funciones para responder a su entorno
) {

    var prompt by remember { mutableStateOf("") }

    // scroll shit
    val listState: LazyListState = rememberLazyListState()

    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty() && messages.size >= 2) {
            listState.animateScrollToItem(messages.size - 2)
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.End
        ) {
            items(messages) { message ->
                when (message.type) {
                    ChatMessageType.AGENT ->
                        LuminMarkdownText(
                            modifier = Modifier.fillMaxWidth(),
                            markdown = message.text
                        )

                    ChatMessageType.USER ->
                        UserMessage(text = message.text)
                }
            }
        }
        MessageBox(
            prompt = prompt,
            onType = {
                prompt = it
            },
            onSend = {
                onSend(prompt)
                prompt = ""
            },
            placeholder = "Escribe tu mensaje"
        )
    }
}