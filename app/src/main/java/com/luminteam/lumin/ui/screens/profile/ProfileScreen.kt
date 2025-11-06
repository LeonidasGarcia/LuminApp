package com.luminteam.lumin.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.Separator
import com.luminteam.lumin.ui.components.SmallText
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.screens.profile.components.PurchaseUltimate
import com.luminteam.lumin.ui.screens.profile.components.UserProgressBar
import com.luminteam.lumin.ui.screens.profile.components.UserStat
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminTheme
import kotlinx.serialization.Serializable

@Serializable
data object ProfileScreen : NavKey

@Composable
fun ProfileScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TitleText(text = "Tu información")
        }
        item {
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder_image),
                    contentDescription = "Foto de perfil placeholder",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    SubtitleText(text = "Leonidas Garcia Lescano")
                    SmallText(text = "leonidasgarcialescano@gmail.com", isUnderlined = true)
                    SmallText(text = "20 años")
                }
            }
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Tus Estadísticas")
        }
        item {
            UserProgressBar(progress = 0.8f)
        }
        item {
            Row {
                UserStat(
                    text = "Nivel más alto alcanzado",
                    valueIcon = R.drawable.basic_icon,
                    iconColor = LuminGreen,
                    valueText = "Básico"
                )
                Spacer(modifier = Modifier.weight(1f))
                UserStat(
                    text = "Secciones superadas",
                    valueIcon = R.drawable.medal_icon,
                    valueText = "40/50"
                )
            }
        }
        item {
            Row {
                UserStat(
                    text = "Última página alcanzada",
                    valueIcon = R.drawable.theory_icon,
                    valueText = "Pág. 24"
                )
                Spacer(modifier = Modifier.weight(1f))
                UserStat(
                    text = "Promedio de prácticas",
                    valueIcon = R.drawable.practice_icon,
                    valueText = "8.5"
                )
            }
        }
        item {
            Row {
                UserStat(
                    text = "Intentos de práctica realizados",
                    valueIcon = R.drawable.retry_icon,
                    iconColor = LuminLightGray,
                    valueText = "51"
                )
                Spacer(modifier = Modifier.weight(1f))
                UserStat(
                    text = "Retos diarios completados",
                    valueIcon = R.drawable.brain_icon,
                    iconColor = LuminOrange,
                    valueText = "12"
                )
            }
        }
        item {
            Separator()
        }
        item {
            PurchaseUltimate()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun ProfileScreenPreview() {
    LuminTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ProfileScreen()
        }

    }
}