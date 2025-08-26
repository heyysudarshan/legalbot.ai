package legalbot.user.onboarding.presentation.themePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import legalbot.user.onboarding.domain.model.theme.Theme
import legalbot.user.onboarding.domain.useCase.theme.ThemeUseCase

internal class ThemePageViewModel(private val themeUseCase: ThemeUseCase) : ViewModel() {
    val uiState = MutableStateFlow(ThemePageUiState())

    init {
        viewModelScope.launch {
            themeUseCase.getThemes().collect { themes ->
                uiState.update { value ->
                    value.copy(themes = themes)
                }
            }
        }
    }

    fun updateSelectedTheme(theme: Theme) {
        themeUseCase.updateSelectedTheme(theme = theme)
    }
}