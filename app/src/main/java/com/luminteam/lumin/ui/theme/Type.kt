package com.luminteam.lumin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.luminteam.lumin.R

val Inter = FontFamily(
    Font(R.font.inter_regular, weight = FontWeight.Normal),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_semibold, weight = FontWeight.SemiBold),
    Font(R.font.inter_bold, weight = FontWeight.Bold)
)

val JetBrainsMono = FontFamily(
    Font(R.font.jetmono_regular, weight = FontWeight.Normal),
    Font(R.font.jetmono_medium, weight = FontWeight.Medium),
    Font(R.font.jetmono_semibold, weight = FontWeight.SemiBold),
    Font(R.font.jetmono_bold, weight = FontWeight.Bold)
)

val Roboto = FontFamily(
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
)

val AppTypography = Typography(
    displayLarge = TextStyle(fontFamily = Inter),
    displayMedium = TextStyle(fontFamily = Inter),
    displaySmall = TextStyle(fontFamily = Inter),
    headlineLarge = TextStyle(fontFamily = Inter),
    headlineMedium = TextStyle(fontFamily = Inter),
    headlineSmall = TextStyle(fontFamily = Inter),
    titleLarge = TextStyle(fontFamily = Inter),
    titleMedium = TextStyle(fontFamily = Inter),
    titleSmall = TextStyle(fontFamily = Inter),
    bodyLarge = TextStyle(fontFamily = Inter),
    bodyMedium = TextStyle(fontFamily = Inter),
    bodySmall = TextStyle(fontFamily = Inter),
    labelLarge = TextStyle(fontFamily = Inter),
    labelMedium = TextStyle(fontFamily = Inter),
    labelSmall = TextStyle(fontFamily = Inter)
)

/*
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)
*/