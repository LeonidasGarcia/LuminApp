package com.luminteam.lumin.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.luminteam.lumin.ui.layout.BottomBar
import com.luminteam.lumin.ui.layout.TopBar
import com.luminteam.lumin.ui.screens.main.MainScreen
import com.luminteam.lumin.ui.screens.profile.ProfileScreen
import com.luminteam.lumin.ui.theme.LuminBackground

@Composable
fun RootNavigation(modifier: Modifier = Modifier) {
    val backStack = remember { mutableStateListOf<Any>(MainScreen) }
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = LuminBackground
        )
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                navigateHome = {
                    backStack.add(MainScreen)
                },
                navigateProfile = {
                    backStack.add(ProfileScreen)
                }
            )
        },

        ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(color = LuminBackground)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                TopBar() {
                    backStack.removeLastOrNull()
                }

                NavDisplay(
                    backStack = backStack,
                    modifier = Modifier.weight(1f),
                    entryDecorators = listOf(
                        rememberSaveableStateHolderNavEntryDecorator(),
                        rememberViewModelStoreNavEntryDecorator()
                    ), entryProvider = entryProvider {
                        entry<MainScreen> { MainScreen() }
                        entry<ProfileScreen> { ProfileScreen() }
                    }
                )
            }

        }


    }
}