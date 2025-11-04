package com.luminteam.lumin.ui.screens.learn.practice.components.questions

import android.util.Log
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.theme.JetBrainsMono
import com.luminteam.lumin.ui.theme.LuminWhite
import com.wakaztahir.codeeditor.highlight.model.CodeLang
import com.wakaztahir.codeeditor.highlight.prettify.PrettifyParser
import com.wakaztahir.codeeditor.highlight.theme.CodeThemeType
import com.wakaztahir.codeeditor.highlight.utils.parseCodeAsAnnotatedString
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.Dp
import com.luminteam.lumin.ui.screens.learn.practice.domain.CompleteTheCodeQuestion
import com.luminteam.lumin.ui.screens.learn.practice.domain.Indent
import com.luminteam.lumin.ui.screens.learn.practice.domain.Line
import com.luminteam.lumin.ui.screens.learn.practice.domain.LineAnnotated
import com.luminteam.lumin.ui.screens.learn.practice.domain.Missing
import com.luminteam.lumin.ui.screens.learn.practice.domain.Token
import com.luminteam.lumin.ui.screens.learn.practice.domain.Word
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminDarkGray
import kotlin.collections.get

val letterDp = 13.dp

@Composable
fun CompleteTheCode(
    question: CompleteTheCodeQuestion,
    onTokenSelected: (List<String?>, MutableMap<Int, String?>) -> Unit
) {
    var currentHole by remember { mutableStateOf(0) }
    var holeMap by remember { mutableStateOf(mutableMapOf<Int, List<Dp>>()) }
    var holeKeys by remember {
        mutableStateOf(
            question.answer.assignedChunks.entries
                .sortedBy { it.key }
                .map { entry ->
                    if (entry.value != null) {
                        entry.key
                    } else {
                        null
                    }
                })
    }
    var assignedChunks by remember { mutableStateOf(question.answer.assignedChunks) }
    var isHoleMapInitialized by remember { mutableStateOf(false) }

    val longestMissingToken = question.missingTokens.maxOf { it.length }
    val codeHoleWidth = letterDp * longestMissingToken

    Column(
        modifier = Modifier
            .background(LuminBackground)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        CodeBlock(
            modifier = Modifier.weight(1f),
            codeLines = question.codeLinesAnnotated,
            codeHoleWidth = codeHoleWidth,
            onHole = { x, y ->
                if (isHoleMapInitialized) return@CodeBlock
                val modifiedHoleMap = holeMap.toMutableMap()
                modifiedHoleMap[currentHole] = listOf(x, y)
                holeMap = modifiedHoleMap

                if (currentHole == question.missingTokens.size - 1) {
                    currentHole = 0
                    isHoleMapInitialized = true
                } else {
                    currentHole++
                }
            })
        CodeChunks(
            chunks = question.missingTokensAnnotated,
            holeMap = holeMap,
            codeHoleWidth = codeHoleWidth,
            assignedChunks = assignedChunks.values.toList(),
            onClick = { isMoved, assignedHole, chunk ->
                if (isMoved) {
                    // se ha movido y no tiene un hueco asignado
                    if (assignedHole == null) {
                        val modifiedHoleKeys = holeKeys.toMutableList()
                        for (key in modifiedHoleKeys.indices) {
                            if (modifiedHoleKeys[key] == null) {
                                modifiedHoleKeys[key] = 1
                                holeKeys = modifiedHoleKeys

                                val modifiedAssignedChunks = assignedChunks.toMutableMap()
                                modifiedAssignedChunks[key] = chunk
                                assignedChunks = modifiedAssignedChunks

                                onTokenSelected(assignedChunks.values.toList(), assignedChunks)

                                return@CodeChunks key
                            }
                        }
                    }
                    // necesario devolver, no quedan más huecos
                    return@CodeChunks assignedHole
                }

                // no se ha movido, pero tien un hueco asignado, se debe desaignar
                if (assignedHole != null) {
                    val modifiedHoleKeys = holeKeys.toMutableList()
                    modifiedHoleKeys[assignedHole] = null
                    holeKeys = modifiedHoleKeys

                    val modifiedAssignedChunks = assignedChunks.toMutableMap()
                    modifiedAssignedChunks[assignedHole] = null
                    assignedChunks = modifiedAssignedChunks

                    onTokenSelected(assignedChunks.values.toList(), assignedChunks)

                    return@CodeChunks null
                }

                return@CodeChunks assignedHole
            })
    }
}

@Composable
fun CodeLine(tokens: List<AnnotatedString?>, codeHoleWidth: Dp, onHole: (Dp, Dp) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        tokens.forEach { token ->
            when (token) {
                is AnnotatedString -> StaticCode(parsedCode = token)
                else -> CodeHole(codeHoleWidth = codeHoleWidth, onHole = onHole)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CodeChunks(
    chunks: List<AnnotatedString>,
    assignedChunks: List<String?>,
    holeMap: MutableMap<Int, List<Dp>>,
    codeHoleWidth: Dp,
    onClick: (Boolean, Int?, String) -> Int?
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        chunks.forEachIndexed { index, chunk ->
            MovableCode(
                chunk = chunk,
                initialOffSet = if (assignedChunks.indexOf(chunk.text) == -1) null else assignedChunks.indexOf(
                    chunk.text
                ),
                holeMap = holeMap,
                codeHoleWidth = codeHoleWidth,
                onClick = onClick
            )
        }
    }
}

@Composable
fun MovableCode(
    chunk: AnnotatedString,
    initialOffSet: Int?,
    holeMap: MutableMap<Int, List<Dp>>,
    codeHoleWidth: Dp,
    onClick: (Boolean, Int?, String) -> Int?
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val scaleTarget = if (isPressed) 0.95f else 1.0f

    val scale by animateFloatAsState(
        targetValue = scaleTarget,
        animationSpec = tween(durationMillis = 100),
        label = "MovableScaleAnim"
    )

    var isRecomposed by remember { mutableStateOf(initialOffSet != null) }

    var initialPositionX by remember { mutableStateOf(0.dp) }
    var initialPositionY by remember { mutableStateOf(0.dp) }

    var thisWidth by remember { mutableStateOf(0.dp) }

    var isMoved by remember { mutableStateOf(false) }
    var assignedHole by remember { mutableStateOf<Int?>(initialOffSet) }

    val density = LocalDensity.current
    val (targetX, targetY) = holeMap[assignedHole]?.toList() ?: listOf(0.dp, 0.dp)

    val offsetX by animateDpAsState(
        targetValue = if (isMoved) -initialPositionX + targetX + (codeHoleWidth / 2) - (thisWidth / 2) else 0.dp,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )

    val offsetY by animateDpAsState(
        targetValue = if (isMoved) -initialPositionY + targetY - 5.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )

    Box(
        modifier = Modifier
            .background(LuminDarkGray, shape = RoundedCornerShape(30.dp))

    ) {
        Box(
            modifier = Modifier
                .offset(
                    x = offsetX,
                    y = offsetY
                )
                .onGloballyPositioned { coordinates ->
                    if (initialPositionX == 0.dp && initialPositionY == 0.dp) {
                        initialPositionX = with(density) {
                            coordinates.positionInWindow().x.toDp()
                        }

                        initialPositionY = with(density) {
                            coordinates.positionInWindow().y.toDp()
                        }

                        thisWidth = with(density) {
                            coordinates.size.width.toDp()
                        }

                        if (isRecomposed) {
                            isRecomposed = false
                            isMoved = true
                        }
                    }
                }
                .scale(scale)
                .clickable(
                    indication = null,
                    interactionSource = interactionSource
                ) {
                    isMoved = !isMoved
                    assignedHole = onClick(isMoved, assignedHole, chunk.text)
                }
                .border(
                    width = 2.dp,
                    color = LuminDarkGray,
                    shape = RoundedCornerShape(30.dp)
                )
                .background(LuminBackground, shape = RoundedCornerShape(30.dp))
        ) {
            StaticCode(
                parsedCode = chunk,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 9.dp)
            )
        }
    }
}

@Composable
fun CodeBlock(
    modifier: Modifier,
    codeLines: List<LineAnnotated>,
    codeHoleWidth: Dp,
    onHole: (Dp, Dp) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        codeLines.forEach { line ->
            CodeLine(tokens = line.tokens, codeHoleWidth = codeHoleWidth, onHole = onHole)
        }
    }
}

@Composable
fun CodeHole(codeHoleWidth: Dp, onHole: (Dp, Dp) -> Unit) {

    val density = LocalDensity.current

    Row(
        modifier = Modifier
            .onGloballyPositioned { coordinates ->
                val x = with(density) {
                    coordinates.positionInWindow().x.toDp()
                }

                val y = with(density) {
                    coordinates.positionInWindow().y.toDp()
                }

                onHole(x, y)
            }
            .width(codeHoleWidth)
            .fillMaxHeight()
            .background(LuminBackground),
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(LuminWhite)
        )
    }
}

@Composable
fun StaticCode(parsedCode: AnnotatedString, modifier: Modifier = Modifier) {
    Text(parsedCode, modifier = modifier, fontFamily = JetBrainsMono, fontSize = 15.sp)
}