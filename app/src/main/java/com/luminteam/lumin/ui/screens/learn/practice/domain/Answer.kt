package com.luminteam.lumin.ui.screens.learn.practice.domain

interface Answer;

data class SingleSelectionAnswer(
    val selection: String? = null
) : Answer

data class FreeResponseAnswer(
    val answer: String = ""
) : Answer

data class FixTheCodeAnswer(
    val correctedCode: String
) : Answer

data class CompleteTheCodeAnswer(
    val orderedTokens: List<String?>,
    val assignedChunks: MutableMap<Int, String?>
) : Answer