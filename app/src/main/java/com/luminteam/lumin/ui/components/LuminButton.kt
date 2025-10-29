package com.luminteam.lumin.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.R
import androidx.compose.ui.unit.Dp
import com.luminteam.lumin.ui.theme.LuminGray
import com.luminteam.lumin.ui.theme.LuminBlack

@Composable
fun LuminButton(
    title: String,
    titleColor: Color = LuminWhite,
    buttonColor: Color,
    icon: Int,
    iconColor: Color,
    modifier: Modifier = Modifier,
    rounded: Dp = 24.dp,
    onClick: () -> Unit = {},
    descriptionColumn: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(rounded),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(6.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    color = titleColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                descriptionColumn()
            }
            Icon(
                painter = painterResource(id = icon),
                tint = iconColor,
                contentDescription = "",
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LuminContinueButton() {
    LuminTheme {
        LuminButton(
            title = "Seguir estudiando",
            titleColor = LuminBlack,
            buttonColor = LuminCyan,
            icon = R.drawable.arrow_icon,
            iconColor = LuminBlack,
            modifier = Modifier.padding(8.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Básico - Variables y Salidas",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = LuminGray
                )
            }
        }
    }
}