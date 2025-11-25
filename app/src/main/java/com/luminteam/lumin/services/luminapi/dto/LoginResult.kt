package com.luminteam.lumin.services.luminapi.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResult(
    val token: String,
    val token_type: String,
    val name: String,
    val email: String
)
