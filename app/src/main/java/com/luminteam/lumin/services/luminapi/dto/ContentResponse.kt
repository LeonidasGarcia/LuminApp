package com.luminteam.lumin.services.luminapi.dto

import com.luminteam.lumin.ui.domain.LevelData
import com.luminteam.lumin.ui.domain.PageData
import com.luminteam.lumin.ui.domain.SectionData
import kotlinx.serialization.Serializable

@Serializable
data class ContentResponse(
    val levels: List<LevelData>,
    val sections: List<SectionData>,
    val pages: List<PageData>
)