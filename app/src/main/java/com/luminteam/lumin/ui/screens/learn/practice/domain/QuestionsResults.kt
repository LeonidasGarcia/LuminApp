package com.luminteam.lumin.ui.screens.learn.practice.domain

import androidx.compose.ui.graphics.Color

data class QuestionsResultsUiState(
    // aquí me deben devolver algo más significativo
    val questionsResults: List<Boolean> = listOf(),
    val resultType: ResultType = ResultType.Disapproved,
    val score: Int = 0
)

enum class ResultType {
    Disapproved,
    Approved,
    FullyAproved
}

data class ResultData(
    val title: String,
    val resultsPercentage: Int,
    val resultsCountIcon: Int,
    val resultCountIconColor: Color,
    val resultsCount: Int,
    val results: List<Int>,
    val resultMessageIcon: Int,
    val resultMessageIconColor: Color,
    val resultMessage: String,
    val needFeedback: Boolean,
    val canContinue: Boolean,
    val canRetry: Boolean
)