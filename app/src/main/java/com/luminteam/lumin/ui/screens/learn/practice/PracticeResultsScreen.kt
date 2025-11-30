package com.luminteam.lumin.ui.screens.learn.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.components.Separator
import com.luminteam.lumin.ui.screens.learn.practice.domain.ResultData
import com.luminteam.lumin.ui.screens.learn.practice.domain.ResultType
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkestGray
import com.luminteam.lumin.ui.theme.LuminGray
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object PracticeResultsScreen : NavKey

@Composable
fun PracticeResultsScreen(
    viewModel: LevelNavigationViewModel,
    navigateFeedback: () -> Unit,
    retryPractice: () -> Unit,
    navigateCurrentTheoryPage: () -> Unit,
    isCurrentSection: Boolean
) {
    val questionsResultsUiState = viewModel.questionsResultsUiState.collectAsStateWithLifecycle()

    val questionsResults = questionsResultsUiState.value.questionsResults
    val resultType = questionsResultsUiState.value.resultType

    val (
        title,
        resultsPercentage,
        resultsCountIcon,
        resultsCountIconColor,
        resultsCount,
        results,
        resultMessageIcon,
        resultMessageIconColor,
        resultMessage,
        needFeedback,
        canContinue,
        canRetry
    ) = when (resultType) {
        ResultType.Disapproved -> {
            ResultData(
                title = "Que pena...",
                resultsPercentage = (questionsResults.filter { it }.size * 100 / questionsResults.size),
                resultsCountIcon = R.drawable.user_icon,
                resultCountIconColor = LuminLightGray,
                resultsCount = questionsResults.filter { !it }.size,
                results = questionsResults.mapIndexed { index, bool ->
                    if (!bool) {
                        index + 1
                    } else {
                        -1
                    }
                }.filter { it != -1 },
                resultMessageIcon = R.drawable.robot_icon,
                resultMessageIconColor = LuminLightGray,
                resultMessage = "Sección no superada",
                needFeedback = true,
                canContinue = false,
                canRetry = true
            )
        }

        ResultType.Approved -> {
            ResultData(
                title = "¡Lo lograste!",
                resultsPercentage = (questionsResults.filter { it }.size * 100 / questionsResults.size),
                resultsCountIcon = R.drawable.retry_icon,
                resultCountIconColor = LuminCyan,
                resultsCount = questionsResults.filter { it }.size,
                results = questionsResults.mapIndexed { index, bool ->
                    if (bool) {
                        index + 1
                    } else {
                        -1
                    }
                }.filter { it != -1 },
                resultMessageIcon = R.drawable.next_arrow_icon,
                resultMessageIconColor = LuminCyan,
                resultMessage = "¡Sección superada!",
                needFeedback = true,
                canContinue = true,
                canRetry = true
            )
        }

        ResultType.FullyApproved -> {
            ResultData(
                title = "¡Lo hiciste perfecto!",
                resultsPercentage = (questionsResults.filter { it }.size * 100 / questionsResults.size),
                resultsCountIcon = R.drawable.retry_icon,
                resultCountIconColor = LuminCyan,
                resultsCount = questionsResults.filter { it }.size,
                results = questionsResults.mapIndexed { index, bool ->
                    if (bool) {
                        index + 1
                    } else {
                        -1
                    }
                }.filter { it != -1 },
                resultMessageIcon = R.drawable.practice_icon,
                resultMessageIconColor = LuminCyan,
                resultMessage = "¡Sección perfectamente superada!",
                needFeedback = false,
                canContinue = true,
                canRetry = true
            )
        }
    }


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(text = title, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LuminDarkestGray, shape = RoundedCornerShape(15.dp))
                    .padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(
                        strokeWidth = 10.dp,
                        strokeCap = StrokeCap.Butt,
                        color = LuminCyan,
                        trackColor = LuminLightGray,
                        modifier = Modifier.size(100.dp),
                        progress = { resultsPercentage.toFloat() * 0.01f }
                    )
                    Text(
                        text = "$resultsPercentage%",
                        color = LuminWhite,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(resultsCountIcon),
                            tint = resultsCountIconColor,
                            contentDescription = "",
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                        )
                        Text(
                            text = (if (resultType == ResultType.Disapproved) "Fallidas" else "Acertadas"),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = resultsCount.toString(), fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(7.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        results.forEach { questionNumber ->
                            Text(
                                text = "Pregunta $questionNumber",
                                color = LuminLightGray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painterResource(resultMessageIcon),
                    tint = resultMessageIconColor,
                    contentDescription = "",
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                )
                Text(
                    text = resultMessage,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        item {
            Separator()
        }

        item {
            Text(text = "¿Qué deseas hacer?", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        }

        if (needFeedback) {
            item {
                LuminButton(
                    title = "Retroalimentación",
                    titleColor = LuminBlack,
                    buttonColor = LuminCyan,
                    icon = R.drawable.robot_icon,
                    iconColor = LuminBlack,
                    modifier = Modifier.padding(8.dp),
                    onClick = navigateFeedback
                ) {
                    Column(
                        modifier = Modifier.width(140.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = "El agente tutor te dará recomendaciones",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            color = LuminGray
                        )
                    }
                }
            }
        }

        if (canContinue && isCurrentSection) {
            item {
                LuminButton(
                    title = "Continuar",
                    titleColor = LuminBlack,
                    buttonColor = LuminGreen,
                    icon = R.drawable.book_icon,
                    iconColor = LuminBlack,
                    modifier = Modifier.padding(8.dp),
                    onClick = navigateCurrentTheoryPage
                ) {
                    Column(
                        modifier = Modifier.width(140.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = "Sección 2 - Tipos de Datos",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            color = LuminGray
                        )
                    }
                }
            }
        }

        if (canRetry) {
            item {
                LuminButton(
                    title = "Intentalo de nuevo",
                    titleColor = LuminWhite,
                    buttonColor = LuminDarkestGray,
                    icon = R.drawable.retry_icon,
                    iconColor = LuminWhite,
                    modifier = Modifier.padding(8.dp),
                    onClick = retryPractice
                ) {
                    Column(
                        modifier = Modifier.width(140.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            text = "El agente tutor te dará recomendaciones",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            color = LuminLightGray
                        )
                    }
                }
            }
        }
    }
}