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
import com.luminteam.lumin.ui.screens.profile.LuminUltimatePurchaseScreen
import com.luminteam.lumin.ui.screens.profile.ProfileScreen
import com.luminteam.lumin.ui.viewmodels.ContentViewModel
import com.luminteam.lumin.ui.viewmodels.RootNavigationViewModel
import com.luminteam.lumin.ui.viewmodels.UserViewModel
import kotlinx.serialization.Serializable

@Serializable
data object ProfileNavigation : NavKey

@Composable
fun ProfileNavigation(
    rootViewModel: RootNavigationViewModel,
    userViewModel: UserViewModel,
    contentViewModel: ContentViewModel
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

    val backStack = rememberNavBackStack(ProfileScreen)

    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ), entryProvider = entryProvider {
            entry<ProfileScreen> {
                updateCurrentBackAction() {}
                updateCanGoBack(false)
                updateShowBottomBar(true)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Perfil",
                        iconTitle = R.drawable.user_icon
                    )
                )
                ProfileScreen(
                    userViewModel = userViewModel,
                    contentViewModel = contentViewModel,
                    navigateUltimatePurchase = {
                        backStack.add(LuminUltimatePurchaseScreen)
                    }
                )
            }
            entry<LuminUltimatePurchaseScreen> {
                updateCurrentBackAction() {
                    backStack.removeLastOrNull()
                    updateShowGeneralPadding(true)
                }
                updateCanGoBack(true)
                updateShowGeneralPadding(false)
                updateShowBottomBar(true)
                updateCurrentTitleTopBar(
                    TitleTopBar(
                        title = "Suscripción",
                        iconTitle = R.drawable.shop_icon
                    )
                )

                LuminUltimatePurchaseScreen()
            }
        }
    )
}