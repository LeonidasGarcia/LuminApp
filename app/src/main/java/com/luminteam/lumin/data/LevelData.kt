package com.luminteam.lumin.data

import androidx.compose.ui.graphics.Color
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminGreen

data class LevelData(
    val name: String,
    val sections: List<SectionData>,
    val titleColor: Color,
    val buttonColor: Color,
    val icon: Int,
    val iconColor: Color,
    val description: String
)
