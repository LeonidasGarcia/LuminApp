package com.luminteam.lumin.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.luminteam.lumin.data.repository.SettingsRepository
import com.luminteam.lumin.services.luminapi.repositories.userRepository
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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

// nuevo viewmodel para separar todo

class UserViewModel(/*private val settingsRepository: SettingsRepository*/) : ViewModel() {
    init {
        viewModelScope.launch {
            val jwt =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2MSIsImV4cCI6MTc2Mzk1OTE1M30.AMksUSj0KNrh5_82q3NE5YfFNZkD5ADFFT38qgkTVKo"

            val userMetrics = userRepository.getUserMetrics(jwt)

            _currentUserDataUiState.value = userRepository.getUserData(jwt)
            _currentUserMetricsDataUiState.value = userMetrics
            _currentUserCalifications.value =
                CalificationsUiState(
                    califications = userRepository.getCalifications(jwt)
                        .associateBy { it.sectionId })
            _currentUserContentState.value = CurrentContentUiState(
                currentLevelId = userMetrics.currentLevelId,
                currentSectionId = userMetrics.currentPageId,
                currentPageId = userMetrics.currentPageId
            )

            Log.d("Datos", "Datos obtenidos: $userMetrics")
        }
    }

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

    /*
        companion object {
            fun provideFactory(repository: SettingsRepository): ViewModelProvider.Factory =
                viewModelFactory {
                    initializer {
                        UserViewModel(repository)
                    }
                }
        }

     */


}