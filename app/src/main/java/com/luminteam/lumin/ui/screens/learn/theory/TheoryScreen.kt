package com.luminteam.lumin.ui.screens.learn.theory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavKey
import com.luminteam.lumin.ui.components.LuminMarkdownText
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.TopBarRightButtonActionType
import com.luminteam.lumin.ui.theme.LuminBlack
import com.luminteam.lumin.ui.theme.LuminCyan
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object TheoryScreen : NavKey

@Composable
fun TheoryScreen(
    rootViewModel: RootNavigationViewModel,
    contentViewModel: ContentViewModel,
    viewModel: LevelNavigationViewModel,
    navigateSection: () -> Unit,
    updateCurrentTitleTopBar: (String, Int) -> Unit
) {
    val currentAppContentState =
        viewModel.currentAppContentState.collectAsStateWithLifecycle().value
    val currentSectionId = currentAppContentState.currentSectionId!!
    val currentSection =
        contentViewModel.sections.collectAsStateWithLifecycle().value.sections[currentSectionId]!!

    val currentPageId = currentAppContentState.currentPageId!!
    // confia en que esta lista contiene id's únicos e irrepetibles
    val pageIdList = currentSection.pages
    val pages = contentViewModel.pages.collectAsStateWithLifecycle().value.pages
    val currentPage = pages[currentPageId]!!

    //val currentSectionState = viewModel.currentSection.collectAsStateWithLifecycle()
    //val theory = currentSectionState.value!!.theory

    val lazyListState = rememberLazyListState()

    // siempre valido
    val currentIndex = pageIdList.indexOf(currentPageId)

    val isNotLastPage = currentIndex < pageIdList.size - 1

    LaunchedEffect(currentPageId) {
        lazyListState.animateScrollToItem(0)
    }

    LaunchedEffect(currentPageId) {
        updateCurrentTitleTopBar("Página " + currentPage.pageNumber, R.drawable.theory_icon)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = lazyListState,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            LuminMarkdownText(
                markdown = currentPage.content
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Boton "Anterior"
                Row(
                    modifier = Modifier
                        .width(150.dp)
                        .background(LuminCyan, shape = RoundedCornerShape(15.dp))
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable {
                            if (currentIndex > 0) {
                                viewModel.updateCurrentAppContentState(
                                    currentAppContentState.copy(
                                        currentPageId = pageIdList[currentIndex - 1]
                                    )
                                )
                            }
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(R.drawable.back_arrow_icon),
                        tint = LuminBlack,
                        contentDescription = "",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Anterior", fontWeight = FontWeight.Bold, color = LuminBlack)
                }
                // boton "Siguiente" o "Terminar"
                Row(
                    modifier = Modifier
                        .width(150.dp)
                        .background(LuminCyan, shape = RoundedCornerShape(15.dp))
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .clickable {
                            if (currentIndex < pageIdList.size - 1) {
                                viewModel.updateCurrentAppContentState(
                                    currentAppContentState.copy(
                                        currentPageId = pageIdList[currentIndex + 1]
                                    )
                                )
                            } else {
                                rootViewModel.updateCurrentTopBarRightButtonActionType(
                                    TopBarRightButtonActionType.SHOW_LIVES
                                )
                                navigateSection()
                            }

                            /*
                            if (isNotLastPage) {
                                currentPageNumber++
                            } else {
                                navigateSection()
                            }
                            */
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isNotLastPage) "Siguiente" else "Terminar",
                        fontWeight = FontWeight.Bold,
                        color = LuminBlack
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        painterResource(R.drawable.next_arrow_icon),
                        tint = LuminBlack,
                        contentDescription = "",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                    )
                }
            }
        }

    }
}