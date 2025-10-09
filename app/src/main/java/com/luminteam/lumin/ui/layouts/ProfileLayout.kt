package com.luminteam.lumin.ui.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminLayout
import com.luminteam.lumin.ui.components.TopBar
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun ProfileLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.user_icon,
                pageText = "Usuario",
                actionButtonIcon = R.drawable.setttings_icon
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
fun ProfileLayoutPreview (
    modifier: Modifier = Modifier
) {
    ProfileLayout {  }
}