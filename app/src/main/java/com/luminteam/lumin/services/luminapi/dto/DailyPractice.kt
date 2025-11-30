package com.luminteam.lumin.services.luminapi.dto

import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import kotlinx.serialization.Serializable

@Serializable
data class DailyPracticeResultsRequest(
    val questions: List<QuestionResponse>,
    val answers: List<AnswerRequest>,
    val userData: UserDataDailyPractice
)

@Serializable
data class UserDataDailyPractice(
    val sectionId: Int
)

@Serializable
data class DailyPracticeResultsResponse(
    val questionsResults: List<Boolean>,
    val resultType: String,
    val score: Int,
    val succededDailyPracticeCount: Int
)