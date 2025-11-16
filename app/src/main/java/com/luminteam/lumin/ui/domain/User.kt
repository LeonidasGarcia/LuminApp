package com.luminteam.lumin.ui.domain

data class UserDataUiState(
    val id: Int,
    val username: String,
    val userIcon: Int,
    val email: String,
    val age: Int,
    val lives: Int,
    val isPremium: Boolean
)

data class UserMetricsDataUiState(
    val currentLevelId: Int,
    val succededSectionsCount: Int,
    val currentPageId: Int,
    val averageScore: Float,
    val totalPracticeRetries: Int,
    val succededDailyPracticeCount: Int,
    val totalSectionsCount: Int
)