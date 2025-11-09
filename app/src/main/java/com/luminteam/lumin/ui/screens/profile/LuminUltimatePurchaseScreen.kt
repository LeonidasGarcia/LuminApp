package com.luminteam.lumin.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.SubtitleText
import com.luminteam.lumin.ui.screens.profile.components.CodeBackground
import com.luminteam.lumin.ui.screens.profile.components.LuminUltimateLogo
import com.luminteam.lumin.ui.screens.profile.components.PurchaseBox
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminBlack
import kotlinx.serialization.Serializable

@Serializable
data object LuminUltimatePurchaseScreen : NavKey

@Composable
fun LuminUltimatePurchaseScreen(
    modifier: Modifier = Modifier
) {
    CodeBackground(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            item {
                SubtitleText(text = "El aprendizaje es mejor con", color = LuminBlack)
            }
            item {
                LuminUltimateLogo()
            }
            item {
                PurchaseBox()
            }
        }
    }
}
