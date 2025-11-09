package com.luminteam.lumin.ui.mock

import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState

val CurrentUserDataUiState0Mock = UserDataUiState(
    id = 0,
    username = "Leonidas Garcia Lescano",
    userIcon = R.drawable.placeholder_image,
    email = "leonidasgarcialescano@gmail.com",
    age = 21,
    lives = 3,
    isPremium = true
)

val CurrentUserMetricsDataUiState0Mock = UserMetricsDataUiState(
    currentLevelId = 0,
    succededSectionsCount = 11,
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
    id = 0,
    sectionId = 0,
    score = 4,
    retries = 1,
    passed = true
)

val Calification1Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 1,
    sectionId = 1,
    score = 4,
    retries = 1,
    passed = true
)

val Calification2Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 2,
    sectionId = 2,
    score = 4,
    retries = 1,
    passed = true
)

val Calification3Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 3,
    sectionId = 3,
    score = 4,
    retries = 1,
    passed = true
)

val Calification4Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 4,
    sectionId = 4,
    score = 4,
    retries = 1,
    passed = true
)

val Calification5Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 5,
    sectionId = 5,
    score = 4,
    retries = 1,
    passed = true
)

val Calification6Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 6,
    sectionId = 6,
    score = 4,
    retries = 1,
    passed = true
)

val Calification7Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 7,
    sectionId = 7,
    score = 4,
    retries = 1,
    passed = true
)

val Calification8Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 8,
    sectionId = 8,
    score = 4,
    retries = 1,
    passed = true
)

val Calification9Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 9,
    sectionId = 9,
    score = 4,
    retries = 1,
    passed = true
)

val Calification10Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 10,
    sectionId = 10,
    score = 4,
    retries = 1,
    passed = true
)

val Calification11Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 11,
    sectionId = 11,
    score = 4,
    retries = 1,
    passed = true
)

val Calification12Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.Calification(
    id = 12,
    sectionId = 12,
    score = 2,
    retries = 4,
    passed = false
)

val Califications0Mock = _root_ide_package_.com.luminteam.lumin.ui.domain.CalificationsUiState(
    califications = mapOf(
        Calification0Mock.id to Calification0Mock,
        Calification1Mock.id to Calification1Mock,
        Calification2Mock.id to Calification2Mock,
        Calification3Mock.id to Calification3Mock,
        Calification4Mock.id to Calification4Mock,
        Calification5Mock.id to Calification5Mock,
        Calification6Mock.id to Calification6Mock,
        Calification7Mock.id to Calification7Mock,
        Calification8Mock.id to Calification8Mock,
        Calification9Mock.id to Calification9Mock,
        Calification10Mock.id to Calification10Mock,
        Calification11Mock.id to Calification11Mock,
        Calification12Mock.id to Calification12Mock
    )
)