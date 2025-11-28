package com.luminteam.lumin.services.luminapi.dto

import com.luminteam.lumin.ui.screens.learn.practice.domain.ResultType
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
@JsonClassDiscriminator("type")
sealed interface AnswerRequest {
    val questionId: Int;
}

@Serializable
data class SingleSelectionAnswerRequest(
    override val questionId: Int,
    @EncodeDefault(EncodeDefault.Mode.ALWAYS)
    val type: String = "SINGLESELECTION",
    val selection: String
) : AnswerRequest

@Serializable
data class FreeResponseAnswerRequest(
    override val questionId: Int,
    @EncodeDefault(EncodeDefault.Mode.ALWAYS)
    val type: String = "FREERESPONSE",
    val answer: String
) : AnswerRequest

@Serializable
data class FixTheCodeAnswerRequest(
    override val questionId: Int,
    @EncodeDefault(EncodeDefault.Mode.ALWAYS)
    val type: String = "FIXTHECODE",
    val answer: String
) : AnswerRequest

@Serializable
data class CompleteTheCodeAnswerRequest(
    override val questionId: Int,
    @EncodeDefault(EncodeDefault.Mode.ALWAYS)
    val type: String = "COMPLETETHECODE",
    val orderedTokens: List<String>,
) : AnswerRequest