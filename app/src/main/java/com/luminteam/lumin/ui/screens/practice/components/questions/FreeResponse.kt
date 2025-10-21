package com.luminteam.lumin.ui.screens.practice.components.questions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminCyan

@Composable
fun FreeResponse() {

    var answer by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Text(
                text = "Escribe la respuesta",
                color = LuminWhite,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            LuminMarkdownText(
                markdown = "Alguna pregunta en markdown xd como estan gente de zona",
                style = TextStyle(fontSize = 20.sp, color = LuminWhite, lineHeight = 35.sp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = answer,
                onValueChange = { answer = it },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(35.dp),
                placeholder = {
                    Text("Escribe aquí tu respuesta")
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
fun FreeRespondePreview() {
    LuminTheme {
        FreeResponse()
    }
}