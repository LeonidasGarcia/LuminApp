package com.luminteam.lumin.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.CalificationsUiState
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.SectionData
import com.luminteam.lumin.ui.screens.learn.levels.components.LockedSectionButton
import com.luminteam.lumin.ui.screens.sections.components.UnlockedSectionButton
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.util.sound.LuminSounds
import com.luminteam.lumin.util.sound.rememberSoundPlayer

data class AccordionValues(
    val iconColor: Color,
    val backgroundColor: Color,
    val textColor: Color
)

@Composable
fun LevelAccordion(
    title: String,
    description: String,
    icon: Int,
    unfoldedIconColor: Color,
    foldedIconColor: Color,
    unfoldedBackgroundColor: Color,
    foldedBackgroundColor: Color,
    unfoldedTextColor: Color,
    foldedTextColor: Color,
    sections: List<SectionData>,
    currentUserContentState: CurrentContentUiState,
    levelId: Int,
    califications: Map<Int, Calification>,
    onSectionSelected: (Int, Int) -> Unit
) {
    val currentSectionId = currentUserContentState.currentSectionId!!

    val foldedValues: AccordionValues = AccordionValues(
        iconColor = foldedIconColor,
        backgroundColor = foldedBackgroundColor,
        textColor = foldedTextColor
    )
    val unfoldedValues: AccordionValues = AccordionValues(
        iconColor = unfoldedIconColor,
        backgroundColor = unfoldedBackgroundColor,
        textColor = unfoldedTextColor
    )

    var unfolded by remember { mutableStateOf(false) }
    val degrees by animateFloatAsState(if (unfolded) 180f else 0f)
    val backgroundColor by animateColorAsState(
        targetValue = if (unfolded) unfoldedValues.backgroundColor else foldedValues.backgroundColor,
        animationSpec = tween(
            durationMillis = 500
        )
    )

    val playSound = rememberSoundPlayer()
    val dropdownSound = if (!unfolded) LuminSounds.DROPDOWN_DOWN else LuminSounds.DROPDOWN_UP

    val selectedValues = if (unfolded) unfoldedValues else foldedValues

    Column(
        modifier = Modifier.background(backgroundColor, shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    unfolded = unfolded.not()
                    playSound(dropdownSound)
                }
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                tint = selectedValues.iconColor,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentDescription = null,
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    title,
                    color = selectedValues.textColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description,
                    color = selectedValues.textColor,
                    fontSize = 12.sp
                )
            }
            Icon(
                painter = painterResource(R.drawable.folded_icon),
                tint = selectedValues.textColor,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .rotate(degrees),
                contentDescription = null,
            )
        }
        AnimatedVisibility(
            visible = unfolded,
            enter = expandVertically(
                spring(
                    stiffness = Spring.StiffnessMediumLow,
                    visibilityThreshold = IntSize.VisibilityThreshold
                )
            ),
            exit = shrinkVertically()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                sections.forEachIndexed { index, section ->
                    val associatedCalification = califications[section.id]
                    val isCurrent = currentSectionId == section.id

                    if (associatedCalification == null && !isCurrent) {
                        LockedSectionButton(
                            title = "Sección " + (index + 1),
                            description = section.name
                        )
                    } else {
                        UnlockedSectionButton(
                            associatedCalification = associatedCalification!!,
                            title = "Sección " + (index + 1),
                            description = section.name,
                            backgroundColor = if (isCurrent) unfoldedValues.iconColor else LuminLightGray,
                            current = isCurrent,
                            onClick = {
                                onSectionSelected(levelId, section.id)
                            }
                        )
                    }
                }
            }
        }
    }
}