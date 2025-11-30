package com.luminteam.lumin.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkestGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.util.sound.LuminSounds
import com.luminteam.lumin.util.sound.rememberSoundPlayer

data class LuminContentTheme(
    val titleColor: Color,
    val descriptionColor: Color,
    val iconColor: Color
)

object LuminContentThemeButtonDefaults {
    val dark = LuminContentTheme(
        titleColor = LuminWhite,
        descriptionColor = LuminLightGray,
        iconColor = LuminWhite
    )

    val light = LuminContentTheme(
        titleColor = LuminBlack,
        descriptionColor = LuminDarkestGray,
        iconColor = LuminBlack
    )
}

@Composable
fun LuminButtonAlt(
    modifier: Modifier = Modifier,
    color: Color = LuminCyan,
    title: String = "Título del botón",
    description: String = "Descripción del botón",
    icon: Int = R.drawable.book_icon,
    contentTheme: LuminContentTheme = LuminContentThemeButtonDefaults.light,
    onClick: () -> Unit = {},
) {
    val playSound = rememberSoundPlayer()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = color)
            .clickable {
                playSound(LuminSounds.TAP)
                onClick()
            }
            .padding(start = 45.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = title,
                color = contentTheme.titleColor,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
            )
            if (description.isNotEmpty()) {
                Text(
                    description,
                    color = contentTheme.descriptionColor,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                )
            }

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(90.dp)
                .height(90.dp),
        ) {
            Icon(
                painter = painterResource(id = icon),
                tint = contentTheme.iconColor,
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun LuminSquareButtonAlt(
    modifier: Modifier = Modifier,
    color: Color = LuminCyan,
    title: String = "Título del botón",
    description: String = "Descripción del botón",
    icon: Int = R.drawable.book_icon,
    contentTheme: LuminContentTheme = LuminContentThemeButtonDefaults.light,
    onClick: () -> Unit = {}
) {
    val playSound = rememberSoundPlayer()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = color)
            .clickable {
                playSound(LuminSounds.TAP)
                onClick()
            },
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    tint = contentTheme.iconColor,
                    contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                )
            }
            Text(
                text = title,
                color = contentTheme.titleColor,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                description,
                color = contentTheme.descriptionColor,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp,
            )
        }
    }
}

@Composable
fun LuminSmallButton(
    modifier: Modifier = Modifier,
    text: String = "Texto del botón",
    textColor: Color = LuminBlack,
    buttonColor: Color = LuminCyan,
    onClick: () -> Unit = {}
) {
    val playSound = rememberSoundPlayer()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .wrapContentWidth()
            .height(45.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = buttonColor)
            .clickable {
                playSound(LuminSounds.TAP)
                onClick()
            }
            .padding(horizontal = 20.dp)

    ) {
        SmallText(text = text, color = textColor, isBold = true)
    }
}



