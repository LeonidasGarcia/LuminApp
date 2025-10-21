package com.luminteam.lumin.ui.screens.practice.components.questions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.ui.theme.LuminBackground
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminWhite
import com.wakaztahir.codeeditor.highlight.model.CodeLang
import com.wakaztahir.codeeditor.highlight.prettify.PrettifyParser
import com.wakaztahir.codeeditor.highlight.theme.CodeThemeType
import com.wakaztahir.codeeditor.highlight.utils.parseCodeAsAnnotatedString

@Composable
fun FixTheCode() {
    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.spacedBy(30.dp)) {
        Text(
            text = "Corrige el código",
            color = LuminWhite,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn() {
            item {
                LuminMarkdownText(
                    markdown = "En el siguiente ejemplo de código hay un error, corrígelo",
                    style = TextStyle(fontSize = 20.sp, color = LuminWhite, lineHeight = 25.sp)
                )
            }
        }
        CodeEditable(modifier = Modifier.weight(1f))
        Button(
            onClick = {}, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                LuminCyan
            )
        ) {
            Text("Corregir", color = LuminBackground, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CodeEditable(modifier: Modifier) {
    val language = CodeLang.Python
    val code = """
        saludo = "hola mundo"
        
        def decir_hola(saludo):
            print(saludo)
           
        decir_hola(saludo)
    """.trimIndent()

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

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            LuminDarkGray
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(LuminDarkGray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LuminCyan)
                    .padding(15.dp)
            ) {
                Text(text = "Python", color = LuminBackground, fontWeight = FontWeight.Bold)
            }
            OutlinedTextField(
                textStyle = TextStyle(fontSize = 15.sp),
                modifier = Modifier
                    .weight(1f)
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
                }
            )
        }
    }


}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun FixTheCodePreview() {
    FixTheCode()
}