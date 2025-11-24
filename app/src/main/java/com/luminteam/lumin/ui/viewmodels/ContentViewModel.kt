package com.luminteam.lumin.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luminteam.lumin.services.luminapi.repositories.contentRepository
import com.luminteam.lumin.services.luminapi.repositories.userRepository
import com.luminteam.lumin.ui.domain.CalificationsUiState
import com.luminteam.lumin.ui.domain.CurrentContentUiState
import com.luminteam.lumin.ui.domain.LevelDataUiState
import com.luminteam.lumin.ui.domain.PageDataUiState
import com.luminteam.lumin.ui.domain.SectionDataUiState
import com.luminteam.lumin.ui.mock.MockLevelsDict
import com.luminteam.lumin.ui.mock.MockPagesDict
import com.luminteam.lumin.ui.mock.MockSectionsDict
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// mover aqui todo el contenido

class ContentViewModel : ViewModel() {

    init {
        viewModelScope.launch {
            val jwt =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2MSIsImV4cCI6MTc2Mzk1OTE1M30.AMksUSj0KNrh5_82q3NE5YfFNZkD5ADFFT38qgkTVKo"

            val content = contentRepository.getContent(jwt)
            
            _levels.value = LevelDataUiState(content.levels.associateBy { it.id })
            _sections.value =
                SectionDataUiState(content.sections.associateBy { it.id })
            _pages.value = PageDataUiState(content.pages.associateBy { it.id })
        }
    }

    private val _levels =
        MutableStateFlow<LevelDataUiState>(LevelDataUiState(levels = MockLevelsDict))
    val levels: StateFlow<LevelDataUiState> = _levels.asStateFlow()

    private val _sections =
        MutableStateFlow<SectionDataUiState>(SectionDataUiState(sections = MockSectionsDict))
    val sections: StateFlow<SectionDataUiState> = _sections.asStateFlow()

    private val _pages = MutableStateFlow<PageDataUiState>(PageDataUiState(pages = MockPagesDict))
    val pages: StateFlow<PageDataUiState> = _pages
}