package com.luminteam.lumin.ui.screens.learn.practice.components.questions

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.screens.learn.practice.domain.SingleSelectionQuestion
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray

@Composable
fun SingleSelection(
    modifier: Modifier = Modifier,
    question: SingleSelectionQuestion,
    onOptionSelected: (String) -> Unit
) {
    val options = question.options

    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = question.question, fontSize = 16.sp)
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            options.forEach { option ->
                Option(
                    isSelected = option == question.answer.selection,
                    option = option,
                    onOptionSelected = onOptionSelected
                )
            }
        }
    }
}

@Composable
fun Option(
    isSelected: Boolean,
    option: String,
    onOptionSelected: (String) -> Unit = {}
) {

    val offsetAnimatable: Animatable<Dp, AnimationVector1D> = remember {
        Animatable(0.dp, Dp.VectorConverter)
    }

    val jumpSpec = keyframes<Dp> {
        durationMillis = 200
        0.dp at 0
        (-5).dp at 100
        0.dp at 200
    }

    LaunchedEffect(isSelected) {
        if (isSelected) {
            offsetAnimatable.animateTo(
                targetValue = 0.dp,
                repeatable(
                    animation = jumpSpec,
                    repeatMode = RepeatMode.Restart,
                    iterations = 1
                )
            )
        }
    }

    Row(
        modifier = Modifier.background(LuminLightGray, shape = RoundedCornerShape(15.dp))
    ) {
        Row(
            modifier = Modifier
                .offset(y = offsetAnimatable.value)
                .border(
                    width = 2.dp,
                    color = if (isSelected) LuminCyan else LuminLightGray,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(
                    color = if (isSelected) LuminDarCyan else LuminDarkGray,
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(vertical = 20.dp)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onOptionSelected(option)
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = option,
                color = if (isSelected) LuminCyan else LuminLightGray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
