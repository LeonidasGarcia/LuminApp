package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.services.luminapi.dto.ContentResponse
import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.LevelData
import com.luminteam.lumin.ui.domain.PageData
import com.luminteam.lumin.ui.domain.SectionData
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import kotlinx.serialization.Serializable

interface Content {
    suspend fun getContent(jwt: String): ContentResponse
}