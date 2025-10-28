package com.luminteam.lumin.data

data class SectionData(
    val title: String,
    val description: String,
    val locked: Boolean = true,
    val theory: TheoryData
)
