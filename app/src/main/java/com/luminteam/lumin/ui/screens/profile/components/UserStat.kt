package com.luminteam.lumin.ui.screens.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.SmallText
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkestGray
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun UserStat(
    modifier: Modifier = Modifier,
    text: String = "Título de estadística",
    valueIcon: Int = R.drawable.basic_icon,
    iconColor: Color = LuminCyan,
    valueText: String = "Valor",
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .width(150.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(15.dp))
            .background(color = LuminDarkestGray)
            .padding(20.dp)
    ) {
        SmallText(text = text)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                painter = painterResource(id = valueIcon),
                tint = iconColor,
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
            )
            SubtitleText(
                text = valueText,
                color = LuminWhite
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun UserStatPreview(
) {
    UserStat(text = "Nivel más alto alcanzado", valueIcon = R.drawable.basic_icon, iconColor = LuminGreen, valueText = "Básico")
}