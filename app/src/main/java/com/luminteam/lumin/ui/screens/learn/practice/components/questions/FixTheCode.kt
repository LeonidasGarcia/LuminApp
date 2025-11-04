package com.luminteam.lumin.ui.screens.learn.practice.components.questions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.screens.learn.practice.domain.FixTheCodeQuestion
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminWhite
import com.wakaztahir.codeeditor.highlight.model.CodeLang
import com.wakaztahir.codeeditor.highlight.prettify.PrettifyParser
import com.wakaztahir.codeeditor.highlight.theme.CodeThemeType
import com.wakaztahir.codeeditor.highlight.utils.parseCodeAsAnnotatedString
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FixTheCode(
    modifier: Modifier = Modifier,
    question: FixTheCodeQuestion,
    onCodeModified: (String) -> Unit
) {

    Column(modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            CodeEditable(code = question.answer.correctedCode, onCodeModified = onCodeModified)
        }
    }
}

@Composable
fun CodeEditable(
    modifier: Modifier = Modifier,
    code: String,
    onCodeModified: (String) -> Unit
) {
    val language = CodeLang.Python
    val code = code.trimIndent()

    val parser = remember { PrettifyParser() }
    var themeState by remember { mutableStateOf(CodeThemeType.Monokai) }
    val theme = remember(themeState) { themeState.theme() }

    var textFieldValue by remember {
        mutableStateOf(
            TextFieldValue(
                annotatedString = parseCodeAsAnnotatedString(
                    parser = parser,
                    theme = theme,
                    lang = language,
                    code = code
                )
            )
        )
    }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(LuminDarkGray)
            .fillMaxWidth()
            .sizeIn(maxHeight = 300.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LuminCyan)
                .padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            Text(text = "Python", color = LuminBackground, fontWeight = FontWeight.Bold)
        }
        OutlinedTextField(
            textStyle = TextStyle(
                fontSize = 17.sp,
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(LuminDarkGray),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = LuminDarkGray,
                focusedContainerColor = LuminDarkGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
            ),
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it.copy(
                    annotatedString = parseCodeAsAnnotatedString(
                        parser = parser,
                        theme = theme,
                        lang = language,
                        code = it.text
                    )
                )
                onCodeModified(it.text)
            }
        )

    }


}