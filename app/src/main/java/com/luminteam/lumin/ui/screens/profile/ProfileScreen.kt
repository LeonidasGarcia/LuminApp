package com.luminteam.lumin.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.Separator
import com.luminteam.lumin.ui.components.SmallText
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.screens.profile.components.PurchaseUltimate
import com.luminteam.lumin.ui.screens.profile.components.UserProgressBar
import com.luminteam.lumin.ui.screens.profile.components.MetricCard
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminRed
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.LuminYellow
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable

@Serializable
data object ProfileScreen : NavKey

data class MetricCardData(
    val text: String,
    val valueIcon: Int,
    val iconColor: Color,
    val valueText: String
)

@Composable
fun ProfileScreen(
    userViewModel: UserViewModel,
    contentViewModel: ContentViewModel,
    navigateUltimatePurchase: () -> Unit
) {
    val currentUserData = userViewModel.currentUserData.collectAsStateWithLifecycle().value
    val currentUserMetricsData =
        userViewModel.currentUserMetricsData.collectAsStateWithLifecycle().value

    val levels = contentViewModel.levels.collectAsStateWithLifecycle().value.levels
    val currentLevel = levels[currentUserMetricsData.currentLevelId]!!

    val pages = contentViewModel.pages.collectAsStateWithLifecycle().value.pages
    val currentPage = pages[currentUserMetricsData.currentPageId]!!

    val metricCardsData = listOf<MetricCardData>(
        MetricCardData(
            text = "Nivel más alto alcanzado",
            valueIcon = when (currentLevel.name) {
                "Básico" -> R.drawable.basic_icon
                "Intermedio" -> R.drawable.intermediate_icon
                "Avanzado" -> R.drawable.advanced_icon
                else -> 0
            },
            iconColor = when (currentLevel.name) {
                "Básico" -> LuminGreen
                "Intermedio" -> LuminYellow
                "Avanzado" -> LuminRed
                else -> LuminWhite
            },
            valueText = currentLevel.name
        ),
        MetricCardData(
            text = "Secciones superadas",
            valueIcon = R.drawable.medal_icon,
            iconColor = LuminCyan,
            valueText = currentUserMetricsData.succededSectionsCount.toString() + "/" + currentUserMetricsData.totalSectionsCount.toString()
        ),
        MetricCardData(
            text = "Última página alcanzada",
            valueIcon = R.drawable.theory_icon,
            iconColor = LuminCyan,
            valueText = "pág. " + currentPage.pageNumber.toString()
        ),
        MetricCardData(
            text = "Promedio de prácticas",
            valueIcon = R.drawable.practice_icon,
            iconColor = LuminCyan,
            valueText = currentUserMetricsData.averageScore.toString()
        ),
        MetricCardData(
            text = "Intentos de práctica realizados",
            valueIcon = R.drawable.retry_icon,
            iconColor = LuminLightGray,
            valueText = currentUserMetricsData.totalPracticeRetries.toString()
        ),
        MetricCardData(
            text = "Retos diarios completados",
            valueIcon = R.drawable.brain_icon,
            iconColor = LuminOrange,
            valueText = currentUserMetricsData.succededDailyPracticeCount.toString()
        )
    )

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
                /*Image(
                    painter = painterResource(id = currentUserData.userIcon),
                    contentDescription = "Foto de perfil placeholder",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(10.dp))
                )*/
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    SubtitleText(text = currentUserData.username)
                    SmallText(text = currentUserData.email, isUnderlined = true)
                    SmallText(text = currentUserData.age.toString() + " años", isUnderlined = true)
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
            UserProgressBar(progress = currentUserMetricsData.succededSectionsCount.toFloat() / currentUserMetricsData.totalSectionsCount.toFloat())
        }
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                metricCardsData.chunked(2).forEach { pair ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier.height(100.dp)
                    ) {
                        pair.forEach { (text, valueIcon, iconColor, valueText) ->
                            MetricCard(
                                modifier = Modifier
                                    .weight(1f),
                                text = text,
                                valueIcon = valueIcon,
                                iconColor = iconColor,
                                valueText = valueText
                            )
                        }
                    }
                }
            }
        }
        item {
            Separator()
        }
        item {
            PurchaseUltimate(navigateUltimatePurchase = navigateUltimatePurchase)
        }
    }
}