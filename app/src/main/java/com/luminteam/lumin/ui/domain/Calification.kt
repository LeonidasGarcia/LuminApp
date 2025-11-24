package com.luminteam.lumin.ui.domain

import kotlinx.serialization.Serializable

@Serializable
data class Calification(
    val sectionId: Int,
    val score: Int,
    val retries: Int,
    val passed: Boolean
)

data class CalificationsUiState(
    val califications: Map<Int, Calification> = mapOf()
)