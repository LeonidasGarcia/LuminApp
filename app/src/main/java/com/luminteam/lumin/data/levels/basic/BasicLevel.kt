package com.luminteam.lumin.data.levels.basic

import com.luminteam.lumin.R
import com.luminteam.lumin.data.LevelData
import com.luminteam.lumin.data.levels.basic.sections.SequentialExecution
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminGreen

val BasicLevel = LevelData(
    name = "Básico",
    sections = listOf(
        SequentialExecution
    ),
    titleColor = LuminBlack,
    buttonColor = LuminGreen,
    icon = R.drawable.arrow_icon,
    iconColor = LuminBlack,
    description = "Lo fundamental"
)