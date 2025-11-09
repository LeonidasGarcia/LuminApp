package com.luminteam.lumin.ui.screens.learn.practice.domain

interface Answer {
    val questionId: Int
}

data class SingleSelectionAnswer(
    val selection: String? = null,
    override val questionId: Int
) : Answer

data class FreeResponseAnswer(
    val answer: String = "",
    override val questionId: Int
) : Answer

data class FixTheCodeAnswer(
    val correctedCode: String,
    override val questionId: Int
) : Answer

data class CompleteTheCodeAnswer(
    val orderedTokens: List<String?>,
    val assignedChunks: MutableMap<Int, String?>,
    override val questionId: Int
) : Answer