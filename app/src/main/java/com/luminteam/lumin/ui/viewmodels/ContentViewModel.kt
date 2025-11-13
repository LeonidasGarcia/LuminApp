package com.luminteam.lumin.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.luminteam.lumin.ui.domain.LevelDataUiState
import com.luminteam.lumin.ui.domain.PageDataUiState
import com.luminteam.lumin.ui.domain.SectionDataUiState
import com.luminteam.lumin.ui.mock.MockLevelsDict
import com.luminteam.lumin.ui.mock.MockPagesDict
import com.luminteam.lumin.ui.mock.MockSectionsDict
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// mover aqui todo el contenido

class ContentViewModel : ViewModel() {
    private val _levels =
        MutableStateFlow<LevelDataUiState>(LevelDataUiState(levels = MockLevelsDict))
    val levels: StateFlow<LevelDataUiState> = _levels.asStateFlow()

    private val _sections =
        MutableStateFlow<SectionDataUiState>(SectionDataUiState(sections = MockSectionsDict))
    val sections: StateFlow<SectionDataUiState> = _sections.asStateFlow()

    private val _pages = MutableStateFlow<PageDataUiState>(PageDataUiState(pages = MockPagesDict))
    val pages: StateFlow<PageDataUiState> = _pages

    fun updateCalifications() {
        // aqui se deben hacer llamadas al servidor de la app
    }
}