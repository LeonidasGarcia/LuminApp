package com.luminteam.lumin.ui.screens.learn.section

import androidx.compose.foundation.layout.Arrangement
import com.luminteam.lumin.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.ui.components.LuminContentThemeButtonDefaults
import com.luminteam.lumin.ui.components.LuminSquareButtonAlt
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object SectionScreen : NavKey

@Composable
fun SectionScreen(
    rootViewModel: RootNavigationViewModel,
    viewModel: LevelNavigationViewModel,
    navigateTheory: () -> Unit,
    navigatePractice: () -> Unit,
) {
    val currentSectionId =
        viewModel.currentAppContentState.collectAsStateWithLifecycle().value.currentSectionId!!
    val sectionData =
        rootViewModel.sections.collectAsStateWithLifecycle().value.sections[currentSectionId]!!

    val currentAppContentState =
        viewModel.currentAppContentState.collectAsStateWithLifecycle().value

    val califications = rootViewModel.califications.collectAsStateWithLifecycle().value

    val calification = califications.califications[currentSectionId]

    val showCalification =
        if (calification == null) "0 intentos" else if (calification.passed) "Superado" else calification.retries.toString() + " intentos"

    // si se seleccionó manualmente, la primera página sera la primera de la teoria
    val navigateTheoryAction: () -> Unit = {
        viewModel.updateCurrentAppContentState(
            currentAppContentState.copy(
                currentPageId = sectionData.pages[0]
            )
        )
        navigateTheory()
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TitleText(
                text = sectionData.name
            )
        }
        item {
            ParagraphText(
                text = sectionData.description
            )
        }
        item {
            TitleText(
                text = "Elige el módulo"
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                LuminSquareButtonAlt(
                    title = "Teoría",
                    icon = R.drawable.theory_icon,
                    description = sectionData.pages.size.toString() + " páginas",
                    onClick = navigateTheoryAction
                )
                Spacer(modifier = Modifier.weight(1f))
                LuminSquareButtonAlt(
                    color = LuminDarkGray,
                    title = "Práctica",
                    icon = R.drawable.practice_icon,
                    description = showCalification,
                    contentTheme = LuminContentThemeButtonDefaults.dark,
                    onClick = navigatePractice
                )
            }
        }
    }
}