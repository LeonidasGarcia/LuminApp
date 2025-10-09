package com.luminteam.lumin.ui.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminLayout
import com.luminteam.lumin.ui.components.TopBar
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun EvaluationLayout(
    modifier: Modifier = Modifier,
    pageText: String = "Pregunta 1",
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = pageText,
                actionButtonIcon = R.drawable.book_icon,
                isActionButtonVisible = false
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
fun EvaluationLayoutPreview (
    modifier: Modifier = Modifier
) {
    EvaluationLayout {  }
}