package com.luminteam.lumin.data.levels.basic

import com.luminteam.lumin.R
import com.luminteam.lumin.data.LevelData
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution2
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution3
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution4
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution5
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminRed
import com.luminteam.lumin.ui.theme.LuminYellow

val BasicLevel = LevelData(
    name = "Básico",
    sections = listOf(
        SequentialExecution,
        SequentialExecution2,
        SequentialExecution3,
        SequentialExecution4,
        SequentialExecution5
    ),
    titleColor = LuminBlack,
    buttonColor = LuminGreen,
    icon = R.drawable.basic_icon,
    iconColor = LuminGreen,
    description = "Lo fundamental"
)

val IntermediateLevel = LevelData(
    name = "Intermedio",
    sections = listOf(
        SequentialExecution,
        SequentialExecution2,
        SequentialExecution3,
        SequentialExecution4,
        SequentialExecution5
    ),
    titleColor = LuminBlack,
    buttonColor = LuminYellow,
    icon = R.drawable.intermediate_icon,
    iconColor = LuminYellow,
    description = "Sube tu nivel"
)

val AdvancedLevel = LevelData(
    name = "Avanzado",
    sections = listOf(
        SequentialExecution,
        SequentialExecution2,
        SequentialExecution3,
        SequentialExecution4,
        SequentialExecution5
    ),
    titleColor = LuminBlack,
    buttonColor = LuminRed,
    icon = R.drawable.advanced_icon,
    iconColor = LuminRed,
    description = "Conviértete en un experto"
)