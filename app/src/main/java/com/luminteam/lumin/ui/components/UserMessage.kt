package com.luminteam.lumin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun UserMessage(
    text: String
) {
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
                text = text,
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