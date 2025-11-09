package com.luminteam.lumin.ui.screens.profile.components

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
import com.luminteam.lumin.ui.components.LuminSmallButton
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun PurchaseUltimate(
    navigateUltimatePurchase: () -> Unit
) {
    CodeBackground(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(15.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubtitleText(
                text = "El aprendizaje es mejor con",
                color = LuminBlack,
            )
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
            SubtitleText(
                text = "Ilumínate con nuestros planes",
                color = LuminBlack
            )
            LuminSmallButton(
                text = "Ver más",
                buttonColor = LuminDarkGray,
                textColor = LuminWhite,
                onClick = navigateUltimatePurchase
            )
        }
    }
}