package com.luminteam.lumin.ui.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserDataUiState(
    val id: Int = -1,
    val username: String = "",
    val email: String = "",
    val age: Int = 0,
    val lives: Int = 0,
    val isPremium: Boolean = false,
    val newLife: String? = null
)

@Serializable
data class UserMetricsDataUiState(
    val currentLevelId: Int = -1,
    val succededSectionsCount: Int = -1,
    val currentSectionId: Int = -1,
    val currentPageId: Int = -1,
    val averageScore: Float = 0f,
    val totalPracticeRetries: Int = -1,
    val succededDailyPracticeCount: Int = -1,
    val totalSectionsCount: Int = -1
)