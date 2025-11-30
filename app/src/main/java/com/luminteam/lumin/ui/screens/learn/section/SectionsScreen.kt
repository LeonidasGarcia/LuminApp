package com.luminteam.lumin.ui.screens.learn.section

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import com.luminteam.lumin.R
import androidx.compose.foundation.layout.Row
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
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.theme.LuminDarkGray
import com.luminteam.lumin.ui.theme.LuminLightGray
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable

@Serializable
data object SectionsScreen : NavKey

@Composable
fun SectionsScreen(
    userViewModel: UserViewModel,
    contentViewModel: ContentViewModel,
    viewModel: LevelNavigationViewModel,
    navigateTheory: () -> Unit,
    navigatePractice: () -> Unit,
) {
    val currentAppContentState =
        viewModel.currentAppContentState.collectAsStateWithLifecycle().value

    val currentAppSectionId =
        currentAppContentState.currentSectionId!!

    val currentSectionAppData =
        contentViewModel.sections.collectAsStateWithLifecycle().value.sections[currentAppSectionId]!!

    val userMetrics = userViewModel.currentUserMetricsData.collectAsStateWithLifecycle().value

    val califications = userViewModel.currentUserCalifications.collectAsStateWithLifecycle().value

    val calification = califications.califications[currentAppSectionId]!!

    // user data
    val currentUserPage =
        contentViewModel.pages.collectAsStateWithLifecycle().value.pages[userMetrics.currentPageId]!!
    val currentUserSection =
        contentViewModel.sections.collectAsStateWithLifecycle().value.sections[userMetrics.currentSectionId]!!

    val canDoPractice =
        // la calificacion ya existe, revisamos si la ha pasado o no usando el boolean de passed
        if (calification.passed) true
        else
            currentUserPage.pageNumber == currentUserSection.pages.size

    val showCalification =
        if (calification.passed) "Superado" else {
            if (canDoPractice) calification.retries.toString() + " intentos"
            else "Bloqueado"
        }

    Log.d("practica", calification.toString())

    // si se seleccionó manualmente, la primera página sera la primera de la teoria
    val navigateTheoryAction: () -> Unit = {
        viewModel.updateCurrentAppContentState(
            currentAppContentState.copy(
                currentPageId = currentSectionAppData.pages[0]
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
                text = currentSectionAppData.name
            )
        }
        item {
            ParagraphText(
                text = currentSectionAppData.description
            )
        }
        item {
            TitleText(
                text = "Elige el módulo"
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                LuminSquareButtonAlt(
                    title = "Teoría",
                    icon = R.drawable.theory_icon,
                    description = currentSectionAppData.pages.size.toString() + " páginas",
                    onClick = navigateTheoryAction
                )
                LuminSquareButtonAlt(
                    color = if (canDoPractice) LuminCyan else LuminDarkGray,
                    title = "Práctica",
                    icon = if (canDoPractice) R.drawable.practice_icon else R.drawable.lock_icon,
                    description = showCalification,
                    contentTheme = if (canDoPractice) LuminContentThemeButtonDefaults.light else LuminContentThemeButtonDefaults.dark,
                    onClick = {
                        if (canDoPractice) {
                            navigatePractice()
                        }
                    }
                )
            }
        }
    }
}