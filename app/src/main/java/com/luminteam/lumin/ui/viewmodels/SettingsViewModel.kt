package com.luminteam.lumin.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.luminteam.lumin.data.repository.LoginRepository
import com.luminteam.lumin.util.alarm.AlarmScheduler
import com.luminteam.lumin.data.repository.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalTime

data class UIState(
    val isSfxOn: Boolean = true,
    val isVibrationOn: Boolean = true,
    val isDailyReminderOn: Boolean = true,
    val dailyReminderTime: String = "20:00",
)

class SettingsViewModel(
    private val settingsRepository: SettingsRepository,
    private val loginRepository: LoginRepository,
    private val alarmScheduler: AlarmScheduler,
) : ViewModel() {
    val uiState: StateFlow<UIState> = combine(
        settingsRepository.isSfxOn,
        settingsRepository.isVibrationOn,
        settingsRepository.isDailyReminderOn,
        settingsRepository.dailyReminderTime,
    ) { sfx, vibration, reminder, reminderTime ->
        UIState(
            isSfxOn = sfx,
            isVibrationOn = vibration,
            isDailyReminderOn = reminder,
            dailyReminderTime = reminderTime,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(1000),
        initialValue = UIState()
    )

    fun logout() {
        viewModelScope.launch {
            loginRepository.deleteJWT()
        }
    }

    fun toggleSfx(value: Boolean) {
        viewModelScope.launch {
            settingsRepository.saveSfx(value)
        }
    }

    fun toggleVibration(value: Boolean) {
        viewModelScope.launch {
            settingsRepository.saveVibration(value)
        }
    }

    fun toggleDailyReminder(value: Boolean) {
        viewModelScope.launch {
            settingsRepository.saveDailyReminder(value)

            if (value) {
                val timeString = settingsRepository.dailyReminderTime.first()
                try {
                    val time = LocalTime.parse(timeString)
                    alarmScheduler.schedule(time)
                } catch (e: Exception) {
                    alarmScheduler.schedule(LocalTime.of(20, 0))
                }
            } else {
                alarmScheduler.cancel()
            }
        }
    }

    fun setDailyReminderTime(hour: Int, minute: Int) {
        viewModelScope.launch {
            val time = LocalTime.of(hour, minute)
            settingsRepository.saveDailyReminderTime(time.toString())

            if (uiState.value.isDailyReminderOn) {
                alarmScheduler.schedule(time)
            }
        }
    }

    companion object {
        fun provideFactory(
            settingsRepository: SettingsRepository,
            loginRepository: LoginRepository,
            scheduler: AlarmScheduler,
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SettingsViewModel(settingsRepository, loginRepository, scheduler)
            }
        }
    }
}