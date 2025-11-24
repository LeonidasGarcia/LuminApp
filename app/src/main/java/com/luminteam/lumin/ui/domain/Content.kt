package com.luminteam.lumin.ui.domain

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

@Serializable
data class LevelData(
    val id: Int,
    val name: String,
    val description: String,
    val sections: List<Int>,
)

@Serializable
data class SectionData(
    val id: Int,
    val name: String,
    val description: String,
    val pages: List<Int>
)

@Serializable
data class PageData(
    val id: Int,
    val content: String,
    val pageNumber: Int
)


data class LevelDataUiState(
    val levels: Map<Int, LevelData> = mapOf()
)

data class SectionDataUiState(
    val sections: Map<Int, SectionData> = mapOf()
)

data class PageDataUiState(
    val pages: Map<Int, PageData> = mapOf()
)