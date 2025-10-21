package com.luminteam.lumin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.markdown.MarkdownStringBuilder
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun LuminChat() {

    var prompt by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Aclara tus dudas",
            color = LuminWhite,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.End
        ) {
            item {
                LuminMarkdownText(
                    modifier = Modifier.fillMaxWidth(),
                    markdown = MarkdownStringBuilder()
                        .addTitle("Variables y Salidas")
                        .addParagraph("Super interesante tema")
                        .addSubtitle("Variables")
                        .addParagraph("Este es el parrafo del tema")
                        .addCode("print('hola mundo')")
                        .addOutput("hola mundo")
                        .build()
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .widthIn(max = 270.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = 20.dp,
                                    topEnd = 20.dp,
                                    bottomStart = 20.dp
                                )
                            )
                            .background(LuminDarkGray)
                            .padding(all = 20.dp),
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Gracias, me ha quedado claro xdd como estas yo muy bien hermanito y tu?",
                            color = LuminWhite
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.user_icon),
                        tint = LuminWhite,
                        contentDescription = "",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .align(Alignment.Bottom)
                    )
                }
            }

            item {
                LuminMarkdownText(
                    modifier = Modifier.fillMaxWidth(),
                    markdown = MarkdownStringBuilder()
                        .addTitle("Variables y Salidas")
                        .addParagraph("Super interesante tema")
                        .addSubtitle("Variables")
                        .addParagraph("Este es el parrafo del tema")
                        .addCode("print('hola mundo')")
                        .addOutput("hola mundo")
                        .build()
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .widthIn(max = 270.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = 20.dp,
                                    topEnd = 20.dp,
                                    bottomStart = 20.dp
                                )
                            )
                            .background(LuminDarkGray)
                            .padding(all = 20.dp),
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Gracias, me ha quedado claro xdd como estas yo muy bien hermanito y tu?",
                            color = LuminWhite
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.user_icon),
                        tint = LuminWhite,
                        contentDescription = "",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .align(Alignment.Bottom)
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = prompt,
                onValueChange = { prompt = it },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(35.dp),
                placeholder = {
                    Text("Escribe tu consulta aquí")
                },
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(LuminCyan),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    painterResource(R.drawable.setttings_icon),
                    tint = LuminWhite,
                    contentDescription = "",
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LuminChatPreview() {
    LuminTheme {
        LuminChat()
    }
}