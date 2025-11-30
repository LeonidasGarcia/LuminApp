package com.luminteam.lumin.ui.screens.learn.practice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminModal
import com.luminteam.lumin.ui.screens.learn.practice.components.QuestionNavigator
import com.luminteam.lumin.ui.screens.learn.practice.components.questions.CompleteTheCode
import com.luminteam.lumin.ui.screens.learn.practice.components.questions.FixTheCode
import com.luminteam.lumin.ui.screens.learn.practice.components.questions.FreeResponse
import com.luminteam.lumin.ui.screens.learn.practice.components.questions.SingleSelection
import com.luminteam.lumin.ui.screens.learn.practice.domain.CompleteTheCodeQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.FixTheCodeQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.FreeResponseQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.SingleSelectionQuestion
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object PracticeScreen : NavKey

@Composable
fun PracticeScreen(
    viewModel: LevelNavigationViewModel,
    updateCurrentTitleTopBar: (String, Int) -> Unit,
    navigatePracticeResults: () -> Unit
) {
    val questionsUiState = viewModel.questionsUiState.collectAsStateWithLifecycle()
    var questionPage by remember { mutableIntStateOf(0) }

    val currentQuestion = questionsUiState.value.questions[questionPage]

    LaunchedEffect(questionPage) {
        updateCurrentTitleTopBar("Pregunta " + (questionPage + 1), R.drawable.practice_icon)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = currentQuestion.title, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        QuestionNavigator(
            isLastQuestion = questionPage == questionsUiState.value.questions.size - 1,
            canGoPrevious = questionPage > 0,
            canGoNext = questionPage < questionsUiState.value.questions.size && currentQuestion.answered,
            onPreviousQuestion = {
                if (questionPage > 0) {
                    questionPage--
                }
            },
            onNextQuestion = {
                if (questionPage < questionsUiState.value.questions.size - 1 && currentQuestion.answered) {
                    questionPage++
                }
            },
            navigatePracticeResults = navigatePracticeResults

        )
        Text(text = currentQuestion.description, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        when (currentQuestion) {
            is SingleSelectionQuestion -> SingleSelection(
                modifier = Modifier.weight(1f),
                question = currentQuestion,
                onOptionSelected = {
                    viewModel.updateSingleSelectionAnswer(
                        questionId = questionPage,
                        selection = it
                    )
                }
            )

            is FreeResponseQuestion -> FreeResponse(
                question = currentQuestion,
                onAnswerChanged = {
                    viewModel.updateFreeResponseAnswer(
                        questionId = questionPage,
                        answer = it
                    )
                }
            )

            is FixTheCodeQuestion -> FixTheCode(
                question = currentQuestion,
                onCodeModified = {
                    viewModel.updateFixTheCodeAnswer(
                        questionId = questionPage,
                        correctedCode = it
                    )
                }
            )

            is CompleteTheCodeQuestion -> CompleteTheCode(
                question = currentQuestion,
                onTokenSelected = { orderedTokens, assignedChunks ->
                    viewModel.updateCompleteTheCodeAnswer(
                        questionId = questionPage,
                        orderedTokens = orderedTokens,
                        assignedChunks = assignedChunks
                    )
                }
            )
        }
    }
}