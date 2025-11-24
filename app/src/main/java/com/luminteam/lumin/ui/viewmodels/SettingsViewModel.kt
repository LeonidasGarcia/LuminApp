package com.luminteam.lumin.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
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
    private val repository: SettingsRepository,
    private val alarmScheduler: AlarmScheduler,
) : ViewModel() {
    val uiState: StateFlow<UIState> = combine(
        repository.isSfxOn,
        repository.isVibrationOn,
        repository.isDailyReminderOn,
        repository.dailyReminderTime,
    ) { sfx, vibration, reminder, reminderTime ->
        UIState(
            isSfxOn = sfx,
            isVibrationOn = vibration,
            isDailyReminderOn = reminder,
            dailyReminderTime = reminderTime,
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000), // Ahorra batería
        initialValue = UIState()
    )

    fun toggleSfx(value: Boolean) {
        viewModelScope.launch {
            repository.saveSfx(value)
        }
    }

    fun toggleVibration(value: Boolean) {
        viewModelScope.launch {
            repository.saveVibration(value)
        }
    }

    fun toggleDailyReminder(value: Boolean) {
        viewModelScope.launch {
            repository.saveDailyReminder(value)

            if (value) {
                val timeString = repository.dailyReminderTime.first()
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
            repository.saveDailyReminderTime(time.toString())

            if (uiState.value.isDailyReminderOn) {
                alarmScheduler.schedule(time)
            }
        }
    }

    companion object {
        fun provideFactory(
            repository: SettingsRepository,
            scheduler: AlarmScheduler,
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SettingsViewModel(repository, scheduler)
            }
        }
    }
}