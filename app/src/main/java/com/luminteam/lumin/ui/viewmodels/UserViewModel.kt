package com.luminteam.lumin.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.luminteam.lumin.ui.domain.CalificationsUiState
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import com.luminteam.lumin.ui.mock.Califications0Mock
import com.luminteam.lumin.ui.mock.CurrentUserDataUiState0Mock
import com.luminteam.lumin.ui.mock.CurrentUserMetricsDataUiState0Mock
import com.luminteam.lumin.ui.mock.UserCurrentContentUiState0Mock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// nuevo viewmodel para separar todo

class UserViewModel : ViewModel() {
    private val _currentUserDataUiState = MutableStateFlow<UserDataUiState>(
        CurrentUserDataUiState0Mock
    )
    val currentUserData: StateFlow<UserDataUiState> = _currentUserDataUiState.asStateFlow()


    private val _currentUserMetricsDataUiState = MutableStateFlow<UserMetricsDataUiState>(
        CurrentUserMetricsDataUiState0Mock
    )
    val currentUserMetricsData: StateFlow<UserMetricsDataUiState> =
        _currentUserMetricsDataUiState.asStateFlow()

    private val _currentUserCalifications =
        MutableStateFlow<CalificationsUiState>(Califications0Mock)
    val currentUserCalifications: StateFlow<CalificationsUiState> =
        _currentUserCalifications.asStateFlow()

    // currentLevelId y currentSectionId siempre serán válidos!!
    private val _currentUserContentState = MutableStateFlow<CurrentContentUiState>(
        UserCurrentContentUiState0Mock
    )
    val currentUserContentState: StateFlow<CurrentContentUiState> =
        _currentUserContentState.asStateFlow()

    fun updateCalifications() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun UpdateUserData() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun updateUserMetricsData() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun updateCurrentContentState() {
        // aquí se deben hacer llamadas al servidor de la app
    }
}