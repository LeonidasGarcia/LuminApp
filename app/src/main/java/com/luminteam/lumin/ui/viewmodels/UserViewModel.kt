package com.luminteam.lumin.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.luminteam.lumin.data.repository.LoginRepository
import com.luminteam.lumin.services.luminapi.dto.SetLastPageRequest
import com.luminteam.lumin.services.luminapi.dto.SetLastPageResponse
import com.luminteam.lumin.services.luminapi.repositories.userRepository
import com.luminteam.lumin.ui.domain.CalificationsUiState
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.UserDataUiState
import com.luminteam.lumin.ui.domain.UserMetricsDataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {
    init {

    }

    private val _currentUserDataUiState = MutableStateFlow<UserDataUiState>(
        UserDataUiState()
    )
    val currentUserData: StateFlow<UserDataUiState> = _currentUserDataUiState.asStateFlow()


    private val _currentUserMetricsDataUiState = MutableStateFlow<UserMetricsDataUiState>(
        UserMetricsDataUiState()
    )
    val currentUserMetricsData: StateFlow<UserMetricsDataUiState> =
        _currentUserMetricsDataUiState.asStateFlow()

    private val _currentUserCalifications =
        MutableStateFlow<CalificationsUiState>(CalificationsUiState(califications = mapOf()))
    val currentUserCalifications: StateFlow<CalificationsUiState> =
        _currentUserCalifications.asStateFlow()

    // currentLevelId y currentSectionId siempre serán válidos!!
    private val _currentUserContentState = MutableStateFlow<CurrentContentUiState>(
        CurrentContentUiState()
    )
    val currentUserContentState: StateFlow<CurrentContentUiState> =
        _currentUserContentState.asStateFlow()

    fun updateCalifications() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun updateUserData() {
        // aqui se deben hacer llamadas al servidor de la app
    }

    fun updateUserMetricsData(userMetricsData: UserMetricsDataUiState) {
        _currentUserMetricsDataUiState.update {
            userMetricsData
        }
    }

    fun updateCurrentContentState() {
        // aquí se deben hacer llamadas al servidor de la app
    }

    fun loadUserData() {
        Log.d("Datos", "Cargando datos de usuario")
        viewModelScope.launch {
            val jwt = loginRepository.jwt.first()
            val userMetrics = userRepository.getUserMetrics(jwt)
            val userData = userRepository.getUserData(jwt)

            _currentUserDataUiState.value = userData
            _currentUserMetricsDataUiState.value = userMetrics
            _currentUserCalifications.value =
                CalificationsUiState(
                    califications = userRepository.getCalifications(jwt, userData.id)
                        .associateBy { it.sectionId })
            _currentUserContentState.value = CurrentContentUiState(
                currentLevelId = userMetrics.currentLevelId,
                currentSectionId = userMetrics.currentSectionId,
                currentPageId = userMetrics.currentPageId
            )
            Log.d("Datos", "Datos obtenidos: $userMetrics")
        }
    }

    suspend fun getProfilePhotoUri(): String {
        return loginRepository.profilePhotoUri.first()
    }

    suspend fun setLastPage(idPage: Int): SetLastPageResponse {
        val jwt = loginRepository.jwt.first()
        return userRepository.postSetLastPage(jwt = jwt, SetLastPageRequest(id_page = idPage))
    }

    companion object {
        fun provideFactory(repository: LoginRepository): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    UserViewModel(repository)
                }
            }
    }
}