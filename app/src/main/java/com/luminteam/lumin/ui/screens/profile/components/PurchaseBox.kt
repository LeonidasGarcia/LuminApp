package com.luminteam.lumin.ui.screens.profile.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminSmallButton
import com.luminteam.lumin.ui.components.SmallText
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.theme.LuminDarkestGray
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun Benefit(
    modifier: Modifier = Modifier,
    text: String = "Beneficio",
    icon: Int = R.drawable.book_icon

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = LuminWhite,
            contentDescription = null,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp),
        )
        SubtitleText(text = text)
    }
}

@Preview
@Composable
fun PurchaseBox(
    modifier: Modifier = Modifier,
    onclick: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(15.dp))
            .background(color = LuminDarkestGray)
            .clickable(onClick = {})
            .padding(20.dp)
    ) {
        SubtitleText(text = "Ilumínate con estos beneficios")
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Benefit(text = "Energía Ilimitada", icon = R.drawable.energy_icon)
            Benefit(text = "Chatbot IA Ilimitado", icon = R.drawable.robot_icon)
            Benefit(text = "Sin Anuncios", icon = R.drawable.cancel_icon)
        }
        LuminSmallButton(
            text = "Pruébalo por PEN0.00",
            onClick = onclick
        )
        SmallText(isCentered = true, text = "Prueba gratuita de 7 días. Aplicable para todos los usuarios que  no haya tenido el plan Lumin Ultimate anteriormente. Después de la prueba se le cobrará PEN10.00 mensualmente.")
    }
}