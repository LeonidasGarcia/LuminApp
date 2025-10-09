package com.luminteam.lumin.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.ui.components.ReturnButton
import com.luminteam.lumin.ui.screens.profile.components.PurchaseUltimate
import com.luminteam.lumin.ui.screens.profile.components.Separator
import com.luminteam.lumin.ui.screens.profile.components.UserPersonalData
import com.luminteam.lumin.ui.screens.profile.components.UserProgress
import com.luminteam.lumin.ui.theme.LuminTheme

@Composable
fun ProfileScreen() {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        ReturnButton()
        UserPersonalData()
        Separator()
        UserProgress()
        Separator()
        PurchaseUltimate()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun ProfileScreenPreview() {
    LuminTheme {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            ProfileScreen()
        }

    }
}