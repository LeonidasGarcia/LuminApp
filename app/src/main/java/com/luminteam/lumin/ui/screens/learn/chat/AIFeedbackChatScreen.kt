package com.luminteam.lumin.ui.screens.learn.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.ui.components.LuminChat
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.domain.ChatMessage
import com.luminteam.lumin.ui.domain.ChatMessageType
import kotlinx.serialization.Serializable

@Serializable
data object AiFeedbackChatScreen : NavKey

@Composable
fun AiFeedbackChatScreen() {
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
            messages = listOf(
                ChatMessage(
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
                ),
                ChatMessage(
                    text = "holaaa, quería hacerte una pregunta :>",
                    type = ChatMessageType.USER
                ),
                ChatMessage(
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
                ),
                ChatMessage(
                    text = "holaaa, quería hacerte una pregunta :>",
                    type = ChatMessageType.USER
                ),
                ChatMessage(
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
                ),
                ChatMessage(
                    text = "holaaa, quería hacerte una pregunta :>",
                    type = ChatMessageType.USER
                )
            )
        )
    }
}