package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.Serializable

data class practiceResultsRequest(
    val questions: List<QuestionResponse>,
    val answers: List<AnswerRequest>,
    val userData: UserData
)

@Serializable
data class UserData(
    val id: Int,
    val sectionId: Int
)

/*
data class practiceResultsResponse(

)
*/