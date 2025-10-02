package com.luminteam.lumin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import com.luminteam.lumin.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.LuminAltGray
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminIntenseGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminVerySoftGray

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818
    )
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    currentPageIcon: Int = R.drawable.book_icon,
    pageText: String = "Aprender",
    energy: Int = 5,
    actionButtonIcon: Int = R.drawable.user_icon,
    isActionButtonVisible: Boolean = true,
    backText: String = "Regresar",
    isBackButtonVisible: Boolean = true

) {
    LuminTheme {
        Column(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(
                        color = LuminIntenseGray,
                        shape = RoundedCornerShape(
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp)
                    )
                    .height(106.dp)
                    .fillMaxWidth()
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                CurrentPageIndicator(icon = currentPageIcon, pageText = pageText)
                LuminLogo()
                Row(
                ) {

                    if (isActionButtonVisible) {
                        EnergyIndicator(energy = energy)
                        Spacer(modifier = Modifier.width(15.dp))
                        ActionButton(actionButtonIcon = actionButtonIcon, onClick = { })
                    } else {
                        Spacer(modifier = Modifier.width(60.dp))
                        EnergyIndicator(energy = energy)
                    }
                }
            }
            if (isBackButtonVisible) {
                Spacer(modifier = Modifier.height(20.dp))
                BackButton(backText = backText)
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
}


@Composable
fun CurrentPageIndicator(
    modifier: Modifier = Modifier,
    icon: Int,
    pageText: String
) {
    Box(
        modifier = Modifier
            .background(
                color = LuminAltGray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(45.dp)
            .width(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = icon),
                contentDescription = "Icono",
                modifier = Modifier.height(24.dp),
                tint = LuminCyan
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
            Text(
                text = pageText,
                color = LuminCyan,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun EnergyIndicator(
    modifier: Modifier = Modifier,
    energy: Int,
) {
    Box(
        modifier = Modifier
            .background(
                color = LuminAltGray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(45.dp)
            .width(60.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = energy.toString(),
                color = LuminVerySoftGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(
                modifier = Modifier
                    .width(4.dp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.energy_icon),
                contentDescription = "Icono",
                modifier = Modifier.height(24.dp),
                tint = LuminVerySoftGray
            )
        }
    }
}


@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    actionButtonIcon: Int,
    onClick : () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                color = LuminAltGray,
                shape = RoundedCornerShape(10.dp)
            )
            .height(45.dp)
            .width(45.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = actionButtonIcon),
                contentDescription = "Icono",
                modifier = Modifier.height(24.dp),
                tint = LuminVerySoftGray
            )
        }
    }
}

@Composable
fun LuminLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.lumin_logo),
        contentDescription = "Logo de Lumin",
        modifier = Modifier.height(45.dp)
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818
)
@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    backText: String = "Regresar"
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.arrow_icon),
            contentDescription = "Icono",
            modifier = Modifier.height(24.dp).scale(scaleX = -1f, scaleY = 1f),
            tint = LuminVerySoftGray
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = backText,
            color = LuminVerySoftGray,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}