package com.luminteam.lumin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun MessageBox(
    placeholder: String,
    prompt: String,
    onType: (String) -> Unit = {},
    onSend: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = prompt,
            onValueChange = {
                onType(it)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = LuminDarkGray,
                focusedContainerColor = LuminDarkGray,
                focusedIndicatorColor = LuminDarkGray,
                unfocusedIndicatorColor = LuminDarkGray,
                disabledIndicatorColor = LuminDarkGray,
                errorIndicatorColor = LuminDarkGray,
            ),
            textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            shape = RoundedCornerShape(35.dp),
            placeholder = {
                Text(placeholder)
            },
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
        )
        Button(
            onClick = {
                if (prompt != "") {
                    onSend()
                }
            },
            modifier = Modifier
                .width(50.dp)
                .height(50.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(LuminCyan),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                painterResource(R.drawable.send_icon),
                tint = LuminWhite,
                contentDescription = "",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
            )
        }
    }
}