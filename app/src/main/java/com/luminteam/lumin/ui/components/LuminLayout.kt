package com.luminteam.lumin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun LuminLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(LuminBackground)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            content()
        }
    }
}