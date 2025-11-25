package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.CalificationsUiState
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState

interface User {
    suspend fun getUserMetrics(jwt: String): UserMetricsDataUiState
    suspend fun getUserData(jwt: String): UserDataUiState
    suspend fun getCalifications(jwt: String, id: Int): List<Calification>
    suspend fun postCreateSubscription()
}