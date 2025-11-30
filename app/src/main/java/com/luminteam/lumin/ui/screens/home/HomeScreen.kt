package com.luminteam.lumin.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.components.LuminButtonAlt
import com.luminteam.lumin.ui.components.ParagraphText
import com.luminteam.lumin.ui.components.Separator
import com.luminteam.lumin.ui.components.TitleText
import com.luminteam.lumin.ui.theme.LuminOrange
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen : NavKey

@Composable
fun HomeScreen(
    userViewModel: UserViewModel,
    contentViewModel: ContentViewModel,
    modifier: Modifier = Modifier,
    navigateCurrentTheoryPage: () -> Unit,
    navigateDailyPractice: () -> Unit
) {
    val currentUserMetrics =
        userViewModel.currentUserMetricsData.collectAsStateWithLifecycle().value

    val levels = contentViewModel.levels.collectAsStateWithLifecycle().value
    val sections = contentViewModel.sections.collectAsStateWithLifecycle().value
    val pages = contentViewModel.pages.collectAsStateWithLifecycle().value

    val currentUserLevelName = levels.levels[currentUserMetrics.currentLevelId]!!.name
    val currentUserSectionName = sections.sections[currentUserMetrics.currentSectionId]!!.name

    val succededUserSectionsCount = currentUserMetrics.succededSectionsCount
    val currentUserPageNumber = pages.pages[currentUserMetrics.currentPageId]!!.pageNumber

    val isNewUser = succededUserSectionsCount == 0 && currentUserPageNumber == 1

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TitleText(
                text = "Bienvenido a Lumin",
            )
        }
        item {
            ParagraphText(
                text = "El lugar ideal para comenzar en el grandioso mundo de la programación. Con perseverencia y esfuerzo te convertirás en un gran programador. ¡Lumin se encargará del resto!",
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "¿Qué deseas hacer?")
        }
        if (!isNewUser) {
            item {
                LuminButtonAlt(
                    title = "Seguir estudiando",
                    description = "$currentUserLevelName: $currentUserSectionName",
                    icon = R.drawable.next_arrow_icon,
                    onClick = navigateCurrentTheoryPage
                )
            }
        }
        item {
            LuminButtonAlt(
                title = "Reto diario",
                description = "¡Ponte a prueba!",
                color = LuminOrange,
                icon = R.drawable.brain_icon,
                onClick = navigateDailyPractice
            )
        }
        item {
            Separator()
        }
        item {
            TitleText(text = "Sabías que...")
        }
        item {
            ParagraphText(text = "El lenguaje de programación Python lleva ese nombre directamente en honor al grupo de comedia británico Monty Python.")
        }
    }
}