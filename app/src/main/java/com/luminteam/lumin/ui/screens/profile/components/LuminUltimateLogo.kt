package com.luminteam.lumin.ui.screens.profile.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminBlack

@Composable
fun LuminUltimateLogo(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.lumin_logo),
            tint = LuminBackground,
            contentDescription = null,
            modifier = Modifier
                .width(80.dp)
                .height(80.dp),
        )
        Text(
            text = "Lumin\nUltimate",
            fontSize = 32.sp,
            fontWeight = FontWeight.Black,
            color = LuminBlack,
            textAlign = TextAlign.Center
        )
    }
}