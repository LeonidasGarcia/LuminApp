package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.services.luminapi.dto.AuthCode
import com.luminteam.lumin.services.luminapi.dto.ContextDataRequest
import com.luminteam.lumin.services.luminapi.dto.LoginResult
import com.luminteam.lumin.services.luminapi.dto.PracticeResponse
import com.luminteam.lumin.services.luminapi.dto.practiceResultsRequest

interface AI {
    suspend fun postPractice(jwt: String, contextData: ContextDataRequest): PracticeResponse
    suspend fun postPracticeResults(
        jwt: String,
        practiceResults: practiceResultsRequest
    )
}