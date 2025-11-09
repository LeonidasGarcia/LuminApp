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
import com.luminteam.lumin.ui.components.LevelAccordion
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.domain.Calification
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.LevelData
import com.luminteam.lumin.ui.domain.LevelDataUiState
import com.luminteam.lumin.ui.domain.SectionData
import com.luminteam.lumin.ui.domain.SectionDataUiState
import com.luminteam.lumin.ui.theme.LuminWhite
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminDarkestGray
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object LevelsScreen : NavKey

@Composable
fun LevelsScreen(
    rootViewModel: RootNavigationViewModel,
    viewModel: LevelNavigationViewModel,
    navigateSection: () -> Unit
) {
    val levels = rootViewModel.levels.collectAsStateWithLifecycle().value.levels
    val sections = rootViewModel.sections.collectAsStateWithLifecycle().value.sections
    val currentUserContentState =
        rootViewModel.currentUserContentState.collectAsStateWithLifecycle().value
    val califications =
        rootViewModel.califications.collectAsStateWithLifecycle().value.califications

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
                icon = level.icon,
                unfoldedIconColor = level.iconColor,
                foldedIconColor = LuminBlack,
                unfoldedBackgroundColor = LuminDarkestGray,
                foldedBackgroundColor = level.buttonColor,
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