package com.luminteam.lumin.services.luminapi.interfaces

import com.luminteam.lumin.services.luminapi.dto.ContextDataRequest
import com.luminteam.lumin.services.luminapi.dto.DailyPracticeResultsRequest
import com.luminteam.lumin.services.luminapi.dto.DailyPracticeResultsResponse
import com.luminteam.lumin.services.luminapi.dto.PracticeResponse
import com.luminteam.lumin.services.luminapi.dto.PracticeResultsRequest
import com.luminteam.lumin.services.luminapi.dto.PracticeResultsResponse
import com.luminteam.lumin.services.luminapi.dto.Questions

interface AI {
    suspend fun postPractice(jwt: String, contextData: ContextDataRequest): PracticeResponse
    suspend fun postPracticeResults(
        jwt: String,
        practiceResults: PracticeResultsRequest
    ): PracticeResultsResponse

    suspend fun postDailyPractice(jwt: String): PracticeResponse
    suspend fun postDailyPracticeResults(
        jwt: String,
        dailyPracticeResults: DailyPracticeResultsRequest
    ): DailyPracticeResultsResponse
}