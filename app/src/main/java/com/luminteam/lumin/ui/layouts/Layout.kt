package com.luminteam.lumin.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.TopBar
import com.luminteam.lumin.ui.theme.LuminTheme

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun MainLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = "Aprender",
                actionButtonIcon = R.drawable.user_icon,
                isBackButtonVisible = false
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun SectionLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = "Sección 1",
                actionButtonIcon = R.drawable.user_icon,
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun ProfileLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.user_icon,
                pageText = "Usuario",
                actionButtonIcon = R.drawable.setttings_icon
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun TheoryLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = "Página 1",
                actionButtonIcon = R.drawable.robot_icon
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun EvaluationLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = "Pregunta 1",
                actionButtonIcon = R.drawable.book_icon,
                isBackButtonVisible = false,
                isActionButtonVisible = false
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun EvaluationResultsLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.book_icon,
                pageText = "Pregunta 1",
                actionButtonIcon = R.drawable.book_icon,
                backText = "Ir a Secciones",
                isActionButtonVisible = false
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun ChatAITutorLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.robot_icon,
                pageText = "Tutor IA",
                actionButtonIcon = R.drawable.book_icon
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF111818,
)
@Composable
fun FeedbackAITutorLayout(
    modifier: Modifier = Modifier
) {
    LuminTheme {
        Column {
            TopBar(
                modifier = modifier,
                currentPageIcon = R.drawable.robot_icon,
                pageText = "Tutor IA",
                actionButtonIcon = R.drawable.book_icon,
                backText = "Volver a Resultados"
            )
        }
    }
}