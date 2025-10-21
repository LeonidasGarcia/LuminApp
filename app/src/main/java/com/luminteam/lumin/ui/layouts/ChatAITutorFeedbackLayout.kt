package com.luminteam.lumin.ui.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminLayout
import com.luminteam.lumin.ui.components.TopBar
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun ChatAITutorFeedbackLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.robot_icon,
                pageText = "Tutor IA",
                actionButtonIcon = R.drawable.book_icon,
                backText = "Volver a Resultados"
            )
            content()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818
)
@Composable
fun ChatAITutorFeedbackLayoutPreview (
    modifier: Modifier = Modifier
) {
        ChatAITutorFeedbackLayout {  }
}