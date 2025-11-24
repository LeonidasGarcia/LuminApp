package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthCode(
    val code: String
)