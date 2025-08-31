package legalbot.user.onboarding.presentation.themePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import compose.app.shared.presentation.composeApp.ComposeAppViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import legalbot.user.onboarding.domain.model.theme.Theme
import compose.app.shared.domain.model.ThemeType
import legalbot.user.onboarding.domain.useCase.theme.ThemeUseCase

internal class ThemePageViewModel(
    private val themeUseCase: ThemeUseCase,
    private val composeAppViewModel: ComposeAppViewModel
) : ViewModel() {
    val uiState = MutableStateFlow(value = ThemePageUiState())

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
        when (theme.type) {
            ThemeType.Light -> {
                composeAppViewModel.updateDarkTheme(isDarkMode = false)
            }
            else -> {
                composeAppViewModel.updateDarkTheme(isDarkMode = true)
            }
        }
    }
}