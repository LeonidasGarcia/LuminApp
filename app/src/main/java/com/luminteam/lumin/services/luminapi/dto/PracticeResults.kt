package com.luminteam.lumin.services.luminapi.dto

import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import kotlinx.serialization.Serializable

@Serializable
data class PracticeResultsRequest(
    val questions: List<QuestionResponse>,
    val answers: List<AnswerRequest>,
    val userData: UserData
)

@Serializable
data class UserData(
    val id: Int,
    val sectionId: Int
)

@Serializable
data class PracticeResultsResponse(
    val questionsResults: List<Boolean>,
    val resultType: String,
    val score: Int,
    val userMetrics: UserMetricsDataUiState,
    val calification: Calification
)