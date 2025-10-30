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
import com.luminteam.lumin.ui.screens.main.MainScreen
import com.luminteam.lumin.ui.screens.profile.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
data object ProfileNavigation : NavKey

@Composable
fun ProfileNavigation() {
    val backStack = rememberNavBackStack(ProfileScreen)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<ProfileScreen> { ProfileScreen() }
        }
    )
}