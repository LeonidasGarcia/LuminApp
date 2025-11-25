package com.luminteam.lumin.ui.screens.learn.levels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LevelAccordion
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminDarkestGray
import com.luminteam.lumin.ui.theme.LuminGreen
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.theme.LuminRed
import com.luminteam.lumin.ui.theme.LuminYellow
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable

@Serializable
data object LevelsScreen : NavKey

@Composable
fun LevelsScreen(
    contentViewModel: ContentViewModel,
    userViewModel: UserViewModel,
    viewModel: LevelNavigationViewModel,
    navigateSection: () -> Unit
) {
    val levels = contentViewModel.levels.collectAsStateWithLifecycle().value.levels
    val sections = contentViewModel.sections.collectAsStateWithLifecycle().value.sections
    val currentUserContentState =
        userViewModel.currentUserContentState.collectAsStateWithLifecycle().value
    val califications =
        userViewModel.currentUserCalifications.collectAsStateWithLifecycle().value.califications

    // legacy
    //val levelsUiState = viewModel.levelsUiState.collectAsStateWithLifecycle()
    // val levels = levelsUiState.value.levels

    val onSectionSelected: (Int, Int) -> Unit = { levelId, sectionId ->
        viewModel.updateCurrentAppContentState(
            CurrentContentUiState(
                currentLevelId = levelId,
                currentSectionId = sectionId
            )
        )
        navigateSection()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            TitleText(
                text = "Niveles"
            )
        }

        item {
            ParagraphText(
                text = "Elige el nivel de conocimientos en el que te encuentras."
            )
        }

        items(
            items = levels.values.toList()
        ) { level ->
            LevelAccordion(
                title = level.name,
                description = level.description,
                icon = when (level.name) {
                    "Básico" -> R.drawable.basic_icon
                    "Intermedio" -> R.drawable.intermediate_icon
                    "Avanzado" -> R.drawable.advanced_icon
                    else -> 0
                },
                unfoldedIconColor = when (level.name) {
                    "Básico" -> LuminGreen
                    "Intermedio" -> LuminYellow
                    "Avanzado" -> LuminOrange
                    else -> LuminWhite
                },
                foldedIconColor = LuminBlack,
                unfoldedBackgroundColor = LuminDarkestGray,
                foldedBackgroundColor = when (level.name) {
                    "Básico" -> LuminGreen
                    "Intermedio" -> LuminYellow
                    "Avanzado" -> LuminOrange
                    else -> LuminWhite
                },
                unfoldedTextColor = LuminWhite,
                foldedTextColor = LuminBlack,
                levelId = level.id,
                sections = level.sections.map { sections[it]!! },
                currentUserContentState = currentUserContentState,
                califications = califications,
                onSectionSelected = onSectionSelected
            )
        }
    }
}