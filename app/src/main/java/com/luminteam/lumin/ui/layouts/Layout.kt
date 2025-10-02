package com.luminteam.lumin.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.TopBar
import com.luminteam.lumin.ui.theme.LuminTheme


@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = "Aprender",
                actionButtonIcon = R.drawable.user_icon,
                isBackButtonVisible = false
            )
            content()
        }
    }
}


@Composable
fun SectionLayout(
    modifier: Modifier = Modifier,
    pageText: String = "Sección 1",
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = pageText,
                actionButtonIcon = R.drawable.user_icon,
            )
            content()
        }
    }
}


@Composable
fun ProfileLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.user_icon,
                pageText = "Usuario",
                actionButtonIcon = R.drawable.setttings_icon
            )
            content()
        }
    }
}

@Composable
fun TheoryLayout(
    modifier: Modifier = Modifier,
    pageText: String = "Página 1",
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = pageText,
                actionButtonIcon = R.drawable.robot_icon
            )
            content()
        }
    }
}

@Composable
fun EvaluationLayout(
    modifier: Modifier = Modifier,
    pageText: String = "Pregunta 1",
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = pageText,
                actionButtonIcon = R.drawable.book_icon,
                isActionButtonVisible = false
            )
            content()
        }
    }
}

@Composable
fun EvaluationResultsLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = "Resultados",
                actionButtonIcon = R.drawable.book_icon,
                backText = "Ir a Secciones",
                isActionButtonVisible = false
            )
            content()
        }
    }
}

@Composable
fun ChatAITutorLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.robot_icon,
                pageText = "Tutor IA",
                actionButtonIcon = R.drawable.book_icon
            )
            content()
        }
    }
}

@Composable
fun FeedbackAITutorLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        LuminLayout {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.robot_icon,
                pageText = "Tutor IA",
                actionButtonIcon = R.drawable.book_icon,
                backText = "Volver a Resultados"
            )
            content()
        }
    }
}

@Composable
fun LuminLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    LuminTheme {
        Column {
            content()
        }
    }
}