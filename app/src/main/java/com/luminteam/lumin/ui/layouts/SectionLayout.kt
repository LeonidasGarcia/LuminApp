package com.luminteam.lumin.ui.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminLayout
import com.luminteam.lumin.ui.components.TopBar
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun SectionLayout(
    modifier: Modifier = Modifier,
    pageText: String = "Sección 1",
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = pageText,
                actionButtonIcon = R.drawable.user_icon,
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
fun SectionLayoutPreview (
    modifier: Modifier = Modifier
) {
    SectionLayout {  }
}