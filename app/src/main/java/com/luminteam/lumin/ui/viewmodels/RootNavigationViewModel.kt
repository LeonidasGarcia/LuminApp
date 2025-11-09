package com.luminteam.lumin.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.luminteam.lumin.R
import com.luminteam.lumin.ui.domain.TopBarBackAction
import com.luminteam.lumin.ui.mock.Califications0Mock
import com.luminteam.lumin.ui.domain.CalificationsUiState
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.LevelDataUiState
import com.luminteam.lumin.ui.mock.MockLevelsDict
import com.luminteam.lumin.ui.mock.MockPagesDict
import com.luminteam.lumin.ui.mock.MockSectionsDict
import com.luminteam.lumin.ui.domain.PageDataUiState
import com.luminteam.lumin.ui.domain.SectionDataUiState
import com.luminteam.lumin.ui.domain.TitleTopBar
import com.luminteam.lumin.ui.domain.TopBarRightButtonActionType
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import com.luminteam.lumin.ui.mock.CurrentUserDataUiState0Mock
import com.luminteam.lumin.ui.mock.CurrentUserMetricsDataUiState0Mock
import com.luminteam.lumin.ui.mock.UserCurrentContentUiState0Mock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RootNavigationViewModel : ViewModel() {
    private val _currentUserDataUiState = MutableStateFlow<UserDataUiState>(
        CurrentUserDataUiState0Mock
    )
    val currentUserData: StateFlow<UserDataUiState> = _currentUserDataUiState.asStateFlow()


    private val _currentUserMetricsDataUiState = MutableStateFlow<UserMetricsDataUiState>(
        CurrentUserMetricsDataUiState0Mock
    )
    val currentUserMetricsData: StateFlow<UserMetricsDataUiState> =
        _currentUserMetricsDataUiState.asStateFlow()

    private val _califications = MutableStateFlow<CalificationsUiState>(Califications0Mock)
    val califications: StateFlow<CalificationsUiState> = _califications.asStateFlow()

    // currentLevelId y currentSectionId siempre serán válidos!!
    private val _currentUserContentState = MutableStateFlow<CurrentContentUiState>(
        UserCurrentContentUiState0Mock
    )
    val currentUserContentState: StateFlow<CurrentContentUiState> =
        _currentUserContentState.asStateFlow()

    private val _levels =
        MutableStateFlow<LevelDataUiState>(LevelDataUiState(levels = MockLevelsDict))
    val levels: StateFlow<LevelDataUiState> = _levels.asStateFlow()

    private val _sections =
        MutableStateFlow<SectionDataUiState>(SectionDataUiState(sections = MockSectionsDict))
    val sections: StateFlow<SectionDataUiState> = _sections.asStateFlow()

    private val _pages = MutableStateFlow<PageDataUiState>(PageDataUiState(pages = MockPagesDict))
    val pages: StateFlow<PageDataUiState> = _pages

    private val _currentTitleTopBar = MutableStateFlow<TitleTopBar>(
        TitleTopBar(
            title = "Inicio",
            iconTitle = R.drawable.home_icon
        )
    )
    val currentTitleTopBar: StateFlow<TitleTopBar> = _currentTitleTopBar.asStateFlow()

    private val _showBottomBar = MutableStateFlow(true)
    val showBottomBar: StateFlow<Boolean> = _showBottomBar.asStateFlow()
    private val _showGeneralPadding = MutableStateFlow(true)
    val showGeneralPadding: StateFlow<Boolean> = _showGeneralPadding.asStateFlow()

    private val _canGoBack = MutableStateFlow(false)
    val canGoBack: StateFlow<Boolean> = _canGoBack.asStateFlow()

    private val _currentTopBarBackAction = MutableStateFlow<TopBarBackAction>({})
    val currentTopBarBackAction: StateFlow<TopBarBackAction> =
        _currentTopBarBackAction.asStateFlow()

    private val _currentTopBarRightButtonActionType =
        MutableStateFlow<TopBarRightButtonActionType>(TopBarRightButtonActionType.SHOW_LIVES)
    val currentTopBarRightButtonActionType: StateFlow<TopBarRightButtonActionType> =
        _currentTopBarRightButtonActionType.asStateFlow()

    private val _showTopBarRightButton = MutableStateFlow(true)
    val showTopBarRightButton: StateFlow<Boolean> = _showTopBarRightButton.asStateFlow()

    fun UpdateUserData() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun updateUserMetricsData() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun updateCalifications() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun updateCurrentContentState() {
        // aquí se deben hacer llamadas al servidor de la app
    }

    fun updateCurrentTopBarRightButtonActionType(rightButtonActionType: TopBarRightButtonActionType) {
        _currentTopBarRightButtonActionType.update {
            rightButtonActionType
        }
    }

    fun updateCurrentTitleTopBar(titleTopBar: TitleTopBar) {
        _currentTitleTopBar.update {
            titleTopBar
        }
    }

    fun updateShowBottomBar(showBottomBar: Boolean) {
        _showBottomBar.update {
            showBottomBar
        }
    }

    fun updateShowTopBarRightButton(showTopBarRightButton: Boolean) {
        _showTopBarRightButton.update {
            showTopBarRightButton
        }
    }

    fun updateShowGeneralPadding(showGeneralPadding: Boolean) {
        _showGeneralPadding.update {
            showGeneralPadding
        }
    }

    fun updateCurrentTopBarBackAction(backAction: TopBarBackAction) {
        _currentTopBarBackAction.update {
            backAction
        }
    }

    fun updateCurrentTopBarRightButtonAction(rightButtonActionType: TopBarRightButtonActionType) {
        _currentTopBarRightButtonActionType.update {
            rightButtonActionType
        }
    }

    fun updateCanGoBack(canGoBack: Boolean) {
        _canGoBack.update {
            canGoBack
        }
    }
}