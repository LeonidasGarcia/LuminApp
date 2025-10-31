package com.luminteam.lumin.ui.screens.learn.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.screens.learn.practice.components.results.FeedbackButton
import com.luminteam.lumin.ui.screens.learn.practice.components.results.Results
import com.luminteam.lumin.ui.screens.learn.practice.components.results.RetryButton
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite

@Composable
fun PracticeResultsScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Que pena...",
            color = LuminWhite,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Results()
        FeedbackButton()
        RetryButton()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun PracticeResultsScreenPreview() {
    LuminTheme {
        PracticeResultsScreen()
    }
}