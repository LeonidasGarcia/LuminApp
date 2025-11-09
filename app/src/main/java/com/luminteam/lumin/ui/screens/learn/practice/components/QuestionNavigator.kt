package com.luminteam.lumin.ui.screens.learn.practice.components


import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun QuestionNavigator(
    isLastQuestion: Boolean,
    canGoPrevious: Boolean,
    canGoNext: Boolean,
    onPreviousQuestion: () -> Unit,
    onNextQuestion: () -> Unit,
    navigatePracticeResults: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()

    val interactionSourceNextButton = remember { MutableInteractionSource() }
    val nextButtonIsPressed by interactionSourceNextButton.collectIsPressedAsState()

    val nextButtonScaleTarget = if (nextButtonIsPressed) 1.05f else 1.0f

    val nextButtonScale by animateFloatAsState(
        targetValue = nextButtonScaleTarget,
        animationSpec = tween(durationMillis = 100),
        label = "NextButtonPressed"
    )

    val interactionSourcePreviousButton = remember { MutableInteractionSource() }
    val previousButtonIsPressed by interactionSourcePreviousButton.collectIsPressedAsState()

    val previousButtonScaleTarget = if (previousButtonIsPressed) 1.05f else 1.0f

    val previousButtonScale by animateFloatAsState(
        targetValue = previousButtonScaleTarget,
        animationSpec = tween(durationMillis = 100),
        label = "NextButtonPressed"
    )

    val scaleAnimatable = remember { Animatable(1f) }

    val pulseSpec = keyframes<Float> {
        durationMillis = 3000
        1f at 0
        1.05f at 1500
        1f at 3000
    }

    LaunchedEffect(canGoNext) {
        if (canGoNext) {
            scaleAnimatable.animateTo(
                targetValue = 1f,
                repeatable(
                    animation = pulseSpec,
                    repeatMode = RepeatMode.Restart,
                    iterations = 2
                )
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .scale(previousButtonScale)
                .clip(RoundedCornerShape(15.dp))
                .background(LuminDarkGray)
                .padding(vertical = 10.dp, horizontal = 15.dp)
                .clickable(
                    indication = null,
                    interactionSource = interactionSourcePreviousButton,
                    enabled = canGoPrevious
                ) {
                    scope.launch {
                        focusManager.clearFocus()
                        delay(300L)
                        onPreviousQuestion()
                    }
                }
                .alpha(if (canGoPrevious) 1f else 0.5f),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.back_arrow_icon),
                contentDescription = "",
                tint = LuminLightGray,
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp)
            )
            Text("Anterior", color = LuminLightGray, fontWeight = FontWeight.Bold)
        }

        Row(
            modifier = Modifier
                .scale(scaleAnimatable.value)
                .scale(nextButtonScale)
                .clip(RoundedCornerShape(15.dp))
                .background(LuminDarkGray)
                .padding(vertical = 10.dp, horizontal = 15.dp)
                .clickable(
                    indication = null,
                    interactionSource = interactionSourceNextButton,
                    enabled = canGoNext
                ) {
                    scope.launch {
                        focusManager.clearFocus()
                        delay(300L)
                        if (isLastQuestion) {
                            navigatePracticeResults()
                        } else {
                            onNextQuestion()
                        }
                    }
                }
                .alpha(if (canGoNext) 1f else 0.5f),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isLastQuestion) "Terminar" else "Siguiente",
                color = LuminLightGray,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(R.drawable.back_arrow_icon),
                contentDescription = "",
                tint = LuminLightGray,
                modifier = Modifier
                    .width(28.dp)
                    .height(28.dp)
                    .rotate(180f)
            )
        }
    }
}