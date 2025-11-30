package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class SetLastPageRequest(
    val id_page: Int
)

@Serializable
data class SetLastPageResponse(
    val id_page: Int,
    val id_section: Int,
    val id_level: Int
)