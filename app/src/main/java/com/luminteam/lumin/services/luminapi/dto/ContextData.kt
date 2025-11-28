package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class ContextDataRequest(
    val contextData: ContextData
)

@Serializable
data class ContextData(
    val levelName: String,
    val sectionName: String
)