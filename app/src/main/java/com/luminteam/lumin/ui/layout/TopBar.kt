package com.luminteam.lumin.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.TitleTopBar
import com.luminteam.lumin.ui.domain.TopBarRightButtonActionType
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray


@Composable
fun TopBar(
    canGoBack: Boolean,
    onBack: () -> Unit,
    titleTopBar: TitleTopBar,
    lives: Int,
    currentRightButtonActionType: TopBarRightButtonActionType,
    navigateAiChat: () -> Unit,
    showTopBarRightButton: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TapBarLeftButton(canGoBack = canGoBack, onBack = onBack)
        TopBarAppState(titleTopBar = titleTopBar)
        TopBarRightButton(
            lives = lives,
            currentLeftButtonActionType = currentRightButtonActionType,
            navigateAiChat = navigateAiChat,
            showTopBarRightButton = showTopBarRightButton
        )
    }
}

@Composable
fun TapBarLeftButton(
    canGoBack: Boolean,
    onBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(if (canGoBack) LuminDarkGray else LuminBackground)
            .padding(13.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                if (canGoBack) {
                    onBack()
                }
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (canGoBack) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow_icon),
                tint = LuminLightGray,
                contentDescription = "",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun TopBarAppState(
    titleTopBar: TitleTopBar,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = titleTopBar.iconTitle),
            tint = LuminCyan,
            contentDescription = "",
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .align(Alignment.CenterVertically)
        )
        Text(text = titleTopBar.title, color = LuminCyan, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun TopBarRightButton(
    lives: Int,
    currentLeftButtonActionType: TopBarRightButtonActionType,
    navigateAiChat: () -> Unit,
    showTopBarRightButton: Boolean
) {
    Row(
        modifier = Modifier
            .width(70.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(if (showTopBarRightButton) LuminDarkGray else LuminBackground)
            .padding(13.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ) {
                when (currentLeftButtonActionType) {
                    TopBarRightButtonActionType.SHOW_LIVES -> {
                        // tooltop logic, probably
                    }

                    TopBarRightButtonActionType.SHOW_AI_CHAT -> {
                        if (showTopBarRightButton) {
                            // ocultar robotito
                            navigateAiChat()
                        }
                    }
                }
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (currentLeftButtonActionType) {
            TopBarRightButtonActionType.SHOW_LIVES -> {
                Text(text = lives.toString(), color = LuminLightGray, fontSize = 20.sp)
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.energy_icon_alt),
                    tint = LuminLightGray,
                    contentDescription = "",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            TopBarRightButtonActionType.SHOW_AI_CHAT ->
                if (showTopBarRightButton) {
                    Icon(
                        painter = painterResource(id = R.drawable.robot_icon),
                        tint = LuminLightGray,
                        contentDescription = "",
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
        }
    }
}