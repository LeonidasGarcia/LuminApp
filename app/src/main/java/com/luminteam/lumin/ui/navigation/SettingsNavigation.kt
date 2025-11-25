package com.luminteam.lumin.ui.navigation

import com.luminteam.lumin.ui.screens.settings.SettingsScreen


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
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.SettingsViewModel
import kotlinx.serialization.Serializable

@Serializable
data object SettingsNavigation : NavKey

@Composable
fun SettingsNavigation(
    rootViewModel: RootNavigationViewModel,
    settingsViewModel: SettingsViewModel,
) {
    val updateCurrentBackAction: (TopBarBackAction) -> Unit = { backAction ->
        rootViewModel.updateCurrentTopBarBackAction(backAction)
    }
    val updateCanGoBack: (Boolean) -> Unit = { canGoBack ->
        rootViewModel.updateCanGoBack(canGoBack)
    }

    val updateShowGeneralPadding: (Boolean) -> Unit = { showGeneralPadding ->
        rootViewModel.updateShowGeneralPadding(showGeneralPadding)
    }

    val updateShowBottomBar: (Boolean) -> Unit = {
        rootViewModel.updateShowBottomBar(it)
    }

    val updateCurrentTitleTopBar: (TitleTopBar) -> Unit = {
        rootViewModel.updateCurrentTitleTopBar(it)
    }

    val backStack = rememberNavBackStack(SettingsScreen)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<SettingsScreen> {
                updateCurrentBackAction { {} }
                updateCanGoBack(false)
                updateShowBottomBar(true)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Ajustes",
                        iconTitle = R.drawable.setttings_icon
                    )
                )
                SettingsScreen(
                    viewModel = settingsViewModel
                )
            }
        }
    )
}