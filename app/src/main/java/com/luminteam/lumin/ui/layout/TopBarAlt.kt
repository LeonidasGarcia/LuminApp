package com.luminteam.lumin.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun TopBarActionButton(
    modifier: Modifier = Modifier,
    text: String = "",
    icon: Int = R.drawable.back_arrow_icon,
    onAction: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (text.isEmpty()) Arrangement.Center else Arrangement.spacedBy(
            4.dp,
            alignment = Alignment.Start
        ),
        modifier = Modifier
            .wrapContentWidth()
            .height(45.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = LuminDarkGray)
            .clickable(onClick = onAction)
            .padding(horizontal = 10.dp),
    ) {
        Text(
            text = text,
            color = LuminLightGray,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
        Icon(
            painter = painterResource(id = icon),
            tint = LuminLightGray,
            contentDescription = null,
            modifier = Modifier
                .width(25.dp)
                .height(25.dp),
        )
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun TopBarAlt(
    modifier: Modifier = Modifier,
    title: String = "Titulo de página",
    icon: Int = R.drawable.book_icon,
    energy: String = "5",
    onBack: () -> Unit = {},
    onEnergy: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .padding(horizontal = 20.dp)
    ) {
        TopBarActionButton(onAction = onBack)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
        ) {
            Icon(
                painter = painterResource(id = icon),
                tint = LuminCyan,
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp),
            )
            Text(
                text = title,
                color = LuminCyan,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
        }
        TopBarActionButton(text = energy, icon = R.drawable.energy_icon_alt, onAction = onEnergy)
    }
}