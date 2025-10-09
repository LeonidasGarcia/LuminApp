package com.luminteam.lumin.ui.screens.section.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun ModuleButton(
    title: String,
    details: String,
    icon: Int,
    selected: Boolean
) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(25.dp),
        contentPadding = PaddingValues(25.dp),
        colors = ButtonDefaults.buttonColors(if (selected) LuminCyan else LuminDarkGray),
        modifier = Modifier
            .width(180.dp)
            .height(180.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                painterResource(id = icon),
                tint = if (selected) LuminBlack else LuminWhite,
                contentDescription = "",
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = if (selected) LuminBlack else LuminWhite
            )
            Text(
                text = details,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = if (selected) LuminGray else LuminLightGray
            )
        }
    }
}