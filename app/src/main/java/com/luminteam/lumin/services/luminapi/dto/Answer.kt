package com.luminteam.lumin.services.luminapi.dto

import com.luminteam.lumin.ui.screens.learn.practice.domain.ResultType
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("type")
sealed interface AnswerRequest {
    val questionId: Int;
}

@Serializable
@SerialName("SINGLESELECTION")
data class SingleSelectionAnswerRequest(
    override val questionId: Int,
    val dtype: String = "SINGLESELECTION",
    val selection: String
) : AnswerRequest

@Serializable
@SerialName("FREERESPONSE")
data class FreeResponseAnswerRequest(
    override val questionId: Int,
    val dtype: String = "FREERESPONSE",
    val answer: String
) : AnswerRequest

@Serializable
@SerialName("FIXTHECODE")
data class FixTheCodeAnswerRequest(
    override val questionId: Int,
    val dtype: String = "FIXTHECODE",
    val answer: String
) : AnswerRequest

@Serializable
@SerialName("COMPLETETHECODE")
data class CompleteTheCodeAnswerRequest(
    override val questionId: Int,
    val dtype: String = "COMPLETETHECODE",
    val orderedTokens: List<String>,
) : AnswerRequest