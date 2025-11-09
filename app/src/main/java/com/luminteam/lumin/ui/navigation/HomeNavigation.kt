package com.luminteam.lumin.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.TopBarBackAction
import com.luminteam.lumin.ui.domain.TitleTopBar
import com.luminteam.lumin.ui.screens.home.HomeScreen
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object HomeNavigation : NavKey

@Composable
fun HomeNavigation(
    rootViewModel: RootNavigationViewModel,
    navigateCurrentTheoryPage: () -> Unit
) {
    val updateCurrentBackAction: (TopBarBackAction) -> Unit = {
        rootViewModel.updateCurrentTopBarBackAction(it)
    }
    val updateCanGoBack: (Boolean) -> Unit = {
        rootViewModel.updateCanGoBack(it)
    }

    val updateShowBottomBar: (Boolean) -> Unit = {
        rootViewModel.updateShowBottomBar(it)
    }

    val updateCurrentTitleTopBar: (TitleTopBar) -> Unit = {
        rootViewModel.updateCurrentTitleTopBar(it)
    }

    val backStack = rememberNavBackStack(HomeScreen)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<HomeScreen> {
                updateCurrentBackAction() {}
                updateCanGoBack(false)
                updateShowBottomBar(true)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Inicio",
                        iconTitle = R.drawable.home_icon
                    )
                )

                HomeScreen(navigateCurrentTheoryPage = navigateCurrentTheoryPage)
            }
        }
    )
}