package com.luminteam.lumin.ui.screens.sections.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButton
import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.util.isFullyApproved
import com.luminteam.lumin.util.sound.LuminSounds
import com.luminteam.lumin.util.sound.rememberSoundPlayer

@Composable
fun UnlockedSectionButton(
    associatedCalification: Calification,
    title: String,
    description: String,
    backgroundColor: Color,
    current: Boolean,
    onClick: () -> Unit
) {
    val icon = if (current) R.drawable.book_icon else {
        val isFullyApproved = isFullyApproved(associatedCalification.score)
        if (isFullyApproved) {
            R.drawable.trophy_icon
        } else {
            R.drawable.medal_icon
        }
    }
    
    val playSound = rememberSoundPlayer()

    LuminButton(
        title = title,
        titleColor = LuminBlack,
        buttonColor = backgroundColor,
        icon = icon,
        iconColor = LuminBlack,
        modifier = Modifier.padding(10.dp),
        onClick = {
            onClick()
            playSound(LuminSounds.TAP)
        }
    ) {
        Column {
            Text(
                text = description,
                color = LuminGray,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            )
        }
    }
}