package com.luminteam.lumin.ui.screens.practice.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.theme.JetBrainsMono
import com.luminteam.lumin.ui.theme.LuminTheme
import com.luminteam.lumin.ui.theme.LuminWhite
import com.wakaztahir.codeeditor.highlight.model.CodeLang
import com.wakaztahir.codeeditor.highlight.prettify.PrettifyParser
import com.wakaztahir.codeeditor.highlight.theme.CodeThemeType
import com.wakaztahir.codeeditor.highlight.utils.parseCodeAsAnnotatedString
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.unit.Dp
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminDarkGray

const val missingToken: String = "?"
const val indent: String = "indent"

val codeLines = listOf<List<String>>(
    listOf("def", missingToken, "():"),
    listOf(indent, "print('Hola mundo')"),
    listOf(missingToken, "()"),
    listOf(missingToken, "()"),
    listOf(missingToken, "()")
)

val missingTokens: List<String> = listOf("saludar", "saludar", "saludar", "saludar")

@Composable
fun CompleteTheCode() {
    var holeMap by remember { mutableStateOf(mutableMapOf<Int, List<Dp>>()) }
    var currentHole by remember { mutableStateOf(0) }
    var holeKeys by remember { mutableStateOf(mutableListOf<Int?>()) }

    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.spacedBy(30.dp)) {
        Text(
            text = "Completa el código",
            color = LuminWhite,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        LuminMarkdownText(
            markdown = "Completa la siguiente muestra de código",
            style = TextStyle(fontSize = 20.sp, color = LuminWhite, lineHeight = 25.sp)
        )
        CodeBlock(modifier = Modifier.weight(1f), onHole = { x, y ->
            val modifiedHoleMap = holeMap.toMutableMap()
            modifiedHoleMap[currentHole] = listOf(x, y)
            holeMap = modifiedHoleMap

            if (currentHole == missingTokens.size - 1) {
                holeKeys = List(size = currentHole + 1) { null }.toMutableList()
                currentHole = 0
            } else {
                currentHole++
            }
        })
        CodeChunks(chunks = missingTokens, holeMap = holeMap, onClick = { isMoved, assignedHole ->
            if (isMoved) {
                if (assignedHole == null) {
                    val modifiedHoleKeys = holeKeys.toMutableList()
                    for (key in modifiedHoleKeys.indices) {
                        if (modifiedHoleKeys[key] == null) {
                            modifiedHoleKeys[key] = 1
                            holeKeys = modifiedHoleKeys
                            return@CodeChunks key
                        }
                    }
                }
                return@CodeChunks assignedHole
            }

            if (assignedHole != null) {
                val modifiedHoleKeys = holeKeys.toMutableList()
                modifiedHoleKeys[assignedHole] = null
                holeKeys = modifiedHoleKeys
                return@CodeChunks null
            }

            return@CodeChunks assignedHole
        })
    }
}

@Composable
fun CodeLine(tokens: List<String>, onHole: (Dp, Dp) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        tokens.forEach { token ->
            if (token == indent) {
                CodeIndent()
            } else if (token == missingToken) {
                CodeHole(onHole = onHole)
            } else {
                StaticCode(code = token)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CodeChunks(
    chunks: List<String>,
    holeMap: MutableMap<Int, List<Dp>>,
    onClick: (Boolean, Int?) -> Int?
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        chunks.forEach { chunk ->
            MovableCode(chunk = chunk, holeMap = holeMap, onClick = onClick)
        }
    }
}

@Composable
fun MovableCode(
    chunk: String,
    holeMap: MutableMap<Int, List<Dp>>,
    onClick: (Boolean, Int?) -> Int?
) {
    var initialPositionX by remember { mutableStateOf(0.dp) }
    var initialPositionY by remember { mutableStateOf(0.dp) }

    var isMoved by remember { mutableStateOf(false) }
    var assignedHole by remember { mutableStateOf<Int?>(null) }

    val density = LocalDensity.current
    val (targetX, targetY) = holeMap[assignedHole]?.toList() ?: listOf(0.dp, 0.dp)

    val offsetX by animateDpAsState(
        targetValue = if (isMoved) -initialPositionX + targetX else 0.dp,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )

    val offsetY by animateDpAsState(
        targetValue = if (isMoved) -initialPositionY + targetY else 0.dp,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )

    Box(
        modifier = Modifier
            .background(LuminDarkGray)
    ) {
        Box(
            Modifier
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
                    }
                }
                .clickable {
                    isMoved = !isMoved
                    assignedHole = onClick(isMoved, assignedHole)
                }
                .clip(RoundedCornerShape(30.dp))
                .background(LuminDarkGray)
        ) {
            StaticCode(
                code = chunk,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
            )
        }
    }
}

@Composable
fun CodeBlock(modifier: Modifier, onHole: (Dp, Dp) -> Unit) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        codeLines.forEach { line ->
            CodeLine(tokens = line, onHole = onHole)
        }
    }
}

@Composable
fun CodeHole(onHole: (Dp, Dp) -> Unit) {

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
            .width(120.dp)
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
fun CodeIndent() {
    StaticCode(code = "    ")
}

@Composable
fun StaticCode(code: String, modifier: Modifier = Modifier) {
    val language = CodeLang.Python
    val code = code

    val parser = remember { PrettifyParser() }
    var themeState by remember { mutableStateOf(CodeThemeType.Monokai) }
    val theme = remember(themeState) { themeState.theme() }

    var parsedCode = remember {
        parseCodeAsAnnotatedString(
            parser = parser,
            theme = theme,
            lang = language,
            code = code
        )
    }

    Text(parsedCode, modifier = modifier, fontFamily = JetBrainsMono, fontSize = 20.sp)
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun CompleteTheCodePreview() {
    LuminTheme {
        CompleteTheCode()
    }
}