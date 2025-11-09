package com.luminteam.lumin.ui.domain

data class Calification(
    val id: Int,
    val sectionId: Int,
    val score: Int,
    val retries: Int,
    val passed: Boolean
)

data class CalificationsUiState(
    val califications: Map<Int, Calification> = mapOf()
)