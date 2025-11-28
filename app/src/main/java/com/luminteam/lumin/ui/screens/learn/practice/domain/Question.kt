package com.luminteam.lumin.ui.screens.learn.practice.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.AnnotatedString
import com.wakaztahir.codeeditor.highlight.model.CodeLang
import com.wakaztahir.codeeditor.highlight.prettify.PrettifyParser
import com.wakaztahir.codeeditor.highlight.theme.CodeThemeType
import com.wakaztahir.codeeditor.highlight.utils.parseCodeAsAnnotatedString

data class QuestionsUiState(
    val questions: List<Question> = listOf()
)

interface Question {
    val id: Int
    val title: String
    val description: String
    val answered: Boolean
        get() = false
    val answer: Answer
    val type: String
}

data class SingleSelectionQuestion(
    val question: String,
    val options: List<String>,
    override val id: Int,
    override val title: String = "Selecciona la Respuesta",
    override val description: String = "Responde a la siguiente pregunta:",
    override val answered: Boolean = false,
    override val answer: SingleSelectionAnswer = SingleSelectionAnswer(questionId = id),
    override val type: String = "SINGLESELECTION"
) : Question

data class FreeResponseQuestion(
    val question: String,
    override val id: Int,
    override val title: String = "Respuesta Libre",
    override val description: String = "Responde a la siguiente pregunta:",
    override val answered: Boolean = false,
    override val answer: FreeResponseAnswer = FreeResponseAnswer(questionId = id),
    override val type: String = "FREERESPONSE"
) : Question

// agregar enunciado
data class FixTheCodeQuestion(
    val wrongCode: String,
    override val id: Int,
    override val title: String = "Arregla el Código",
    override val description: String = "El siguiente bloque de código tiene un error, corrígelo:",
    override val answered: Boolean = false,
    override val answer: FixTheCodeAnswer = FixTheCodeAnswer(
        questionId = id,
        correctedCode = wrongCode
    ),
    override val type: String = "FIXTHECODE"
) : Question

data class CompleteTheCodeQuestion(
    val codeLines: List<Line>,
    val missingTokens: List<String>,
    val codeLinesAnnotated: List<LineAnnotated> = codeLines.map { line ->
        LineAnnotated(
            tokens = loadAnnotatedStrings(
                line.tokens
            )
        )
    },
    val missingTokensAnnotated: List<AnnotatedString> = loadAnnotatedStrings(tokens = missingTokens.map { token ->
        Word(
            token
        )
    }).filterNotNull(),
    override val id: Int,
    override val title: String = "Completa el Código",
    override val description: String = "Completa el siguiente bloque de código:",
    override val answered: Boolean = false,
    override val answer: CompleteTheCodeAnswer = CompleteTheCodeAnswer(
        orderedTokens = List(size = missingTokens.size) { null },
        assignedChunks = IntRange(0, missingTokens.size - 1).associateWith {
            null as String?
        }.toMutableMap(),
        questionId = id
    ),
    override val type: String = "COMPLETETHECODE"
) : Question

// es necesario manejar esto apenas llegue una pregunta del tipo COMPLETE_THE_CODE
fun loadAnnotatedStrings(tokens: List<Token>): List<AnnotatedString?> {
    val language = CodeLang.Python
    val parser = PrettifyParser()
    val theme = CodeThemeType.Monokai.theme()

    return tokens.map<Token, AnnotatedString?> { token ->
        if (token is Indent) {
            parseCodeAsAnnotatedString(
                parser = parser,
                theme = theme,
                lang = language,
                code = "    "
            )
        } else if (token is Word) {
            parseCodeAsAnnotatedString(
                parser = parser,
                theme = theme,
                lang = language,
                code = token.token
            )
        } else {
            null
        }
    }
}

class Line(val tokens: List<Token>)

class LineAnnotated(val tokens: List<AnnotatedString?>)

sealed interface Token {}

object Indent : Token
object Missing : Token
data class Word(val token: String) : Token
