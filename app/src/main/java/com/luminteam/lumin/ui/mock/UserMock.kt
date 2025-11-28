package com.luminteam.lumin.ui.mock

import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState

val CurrentUserDataUiState0Mock = UserDataUiState(
    id = 0,
    username = "Leonidas Garcia Lescano",
    email = "leonidasgarcialescano@gmail.com",
    age = 21,
    lives = 3,
    isPremium = true,
    newLife = ""
)

val CurrentUserMetricsDataUiState0Mock = UserMetricsDataUiState(
    currentLevelId = 0,
    succededSectionsCount = 11,
    currentSectionId = 12,
    currentPageId = 70,
    averageScore = 4.2f,
    totalPracticeRetries = 16,
    succededDailyPracticeCount = 5,
    totalSectionsCount = 21
)

val UserCurrentContentUiState0Mock = CurrentContentUiState(
    currentLevelId = 1,
    currentSectionId = 12,
    currentPageId = 70
)

val Calification0Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 0,
    score = 4,
    retries = 1,
    passed = true
)

val Calification1Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 1,
    score = 4,
    retries = 1,
    passed = true
)

val Calification2Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 2,
    score = 4,
    retries = 1,
    passed = true
)

val Calification3Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 3,
    score = 4,
    retries = 1,
    passed = true
)

val Calification4Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 4,
    score = 4,
    retries = 1,
    passed = true
)

val Calification5Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 5,
    score = 4,
    retries = 1,
    passed = true
)

val Calification6Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 6,
    score = 4,
    retries = 1,
    passed = true
)

val Calification7Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 7,
    score = 4,
    retries = 1,
    passed = true
)

val Calification8Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 8,
    score = 4,
    retries = 1,
    passed = true
)

val Calification9Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 9,
    score = 4,
    retries = 1,
    passed = true
)

val Calification10Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 10,
    score = 4,
    retries = 1,
    passed = true
)

val Calification11Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 11,
    score = 4,
    retries = 1,
    passed = true
)

val Calification12Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    sectionId = 12,
    score = 2,
    retries = 4,
    passed = false
)

val Califications0Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.CalificationsUiState(
    califications = mapOf(
        Calification0Mock.sectionId to Calification0Mock,
        Calification1Mock.sectionId to Calification1Mock,
        Calification2Mock.sectionId to Calification2Mock,
        Calification3Mock.sectionId to Calification3Mock,
        Calification4Mock.sectionId to Calification4Mock,
        Calification5Mock.sectionId to Calification5Mock,
        Calification6Mock.sectionId to Calification6Mock,
        Calification7Mock.sectionId to Calification7Mock,
        Calification8Mock.sectionId to Calification8Mock,
        Calification9Mock.sectionId to Calification9Mock,
        Calification10Mock.sectionId to Calification10Mock,
        Calification11Mock.sectionId to Calification11Mock,
        Calification12Mock.sectionId to Calification12Mock
    )
)