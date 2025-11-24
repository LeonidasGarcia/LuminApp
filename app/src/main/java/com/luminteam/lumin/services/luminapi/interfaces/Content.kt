package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.LevelData
import com.luminteam.lumin.ui.domain.PageData
import com.luminteam.lumin.ui.domain.SectionData
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import kotlinx.serialization.Serializable

@Serializable
data class ContentResponse(
    val levels: List<LevelData>,
    val sections: List<SectionData>,
    val pages: List<PageData>
)

interface Content {
    suspend fun getContent(jwt: String): ContentResponse
}