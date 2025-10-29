package com.luminteam.lumin.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminGray
import com.luminteam.lumin.ui.theme.LuminLightGray

@Composable
fun TopBar(
    onBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(20.dp))
                .background(LuminDarkGray)
                .padding(13.dp)
                .clickable {
                    onBack()
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_icon),
                tint = LuminLightGray,
                contentDescription = "",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.CenterVertically)
                    .rotate(-90f)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.book_icon),
                tint = LuminCyan,
                contentDescription = "",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(text = "Inicio", color = LuminCyan, fontWeight = FontWeight.Bold)
        }
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(20.dp))
                .background(LuminDarkGray)
                .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "5", color = LuminLightGray, fontSize = 20.sp)
            Icon(
                painter = painterResource(id = R.drawable.energy_icon),
                tint = LuminLightGray,
                contentDescription = "",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .align(Alignment.CenterVertically)
            )
        }

    }
}