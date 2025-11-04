package com.luminteam.lumin.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.luminteam.lumin.ui.screens.learn.practice.PracticeScreen
import com.luminteam.lumin.ui.screens.profile.ProfileScreen
import com.luminteam.lumin.ui.viewmodels.LevelNavigationViewModel
import kotlinx.serialization.Serializable

@Serializable
data object LevelNavigation : NavKey

@Composable
fun LevelNavigation(
    viewModel: LevelNavigationViewModel = viewModel()
) {
    val backStack = rememberNavBackStack(PracticeScreen)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier
            .fillMaxSize(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<PracticeScreen> { PracticeScreen(viewModel = viewModel) }
        }
    )
}