package com.luminteam.lumin.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.luminteam.lumin.ui.domain.ChatMessage
import com.luminteam.lumin.ui.domain.ChatMessageType
import com.luminteam.lumin.ui.mock.messagesMock
import com.luminteam.lumin.ui.screens.learn.practice.domain.Answer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AIChatViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(messagesMock)
    var messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    fun addUserMessage(newUserMessage: String) {
        _messages.update {
            it + ChatMessage(
                text = newUserMessage,
                type = ChatMessageType.USER
            )
        }

        fetchLastAIMessage()
    }

    // logic for send message to ai chat
    fun fetchLastAIMessage() {
        _messages.update {
            it + ChatMessage(
                text = """### **1. Ejemplo de automatización**

```python
import os

for archivo in os.listdir():
    if archivo.endswith(".txt"):
        print("Archivo encontrado:", archivo)
```

```txt
Output:
Archivo encontrado: notas.txt
```

### **2. Automatizar con tiempo**

```python
import time

print("Iniciando tarea...")
time.sleep(3)
print("Tarea completada ✅")
```

🧩 Ideal si te interesa **crear herramientas útiles** o **mejorar tu flujo de trabajo diario**.


### **3. Librerías comunes**

|Propósito|Librería|
|---|---|
|Control del sistema|os, sys|
|Web scraping|requests, BeautifulSoup|
|Automatización de navegador|selenium|
|Archivos y datos|csv, json, shutil|""",
                type = ChatMessageType.AGENT
            )
        }
    }

    // for feedback chat
    fun fetchFeedBackMessage(answers: List<Answer>) {

    }

    fun clearMessages() {
        Log.d("clear", "limpiando")
        _messages.update {
            listOf()
        }
    }
}