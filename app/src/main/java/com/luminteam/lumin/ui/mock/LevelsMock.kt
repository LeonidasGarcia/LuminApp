package com.luminteam.lumin.ui.mock

import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.LevelData
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminRed
import com.luminteam.lumin.ui.theme.LuminYellow

val BasicMockLevel = LevelData(
    id = 0,
    name = "Básico",
    description = "Lo fundamental",
    sections = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
)

val IntermediateMockLevel = LevelData(
    id = 1,
    name = "Intermedio",
    description = "Sube tu nivel",
    sections = listOf(9, 10, 11, 12, 13, 14, 15),
)

val AdvancedMOckLevel = LevelData(
    id = 2,
    name = "Avanzado",
    description = "Conviértete en experto",
    sections = listOf(16, 17, 18, 19, 20),
)