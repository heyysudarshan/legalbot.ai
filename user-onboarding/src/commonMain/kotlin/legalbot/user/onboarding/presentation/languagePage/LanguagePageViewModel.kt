package legalbot.user.onboarding.presentation.languagePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import legalbot.user.onboarding.domain.model.Language
import legalbot.user.onboarding.domain.useCase.LanguageUseCase

internal class LanguagePageViewModel(
    private val languageUseCase: LanguageUseCase,
) : ViewModel() {
    var uiState = MutableStateFlow(LanguagePageUiState())
        private set

    init {
        viewModelScope.launch {
            languageUseCase.getLanguages().collect { languages ->
                uiState.value = LanguagePageUiState(languages = languages)
            }
        }
        addAnimationDuration()
    }

    fun updateSelectedLanguage(language: Language) {
        languageUseCase.updateSelectedLanguage(language = language)
    }

    private fun addAnimationDuration() {
        var lastKnownDelay = 0L
        uiState.update { value ->
            value.copy(
                languages = value.languages.map {
                    lastKnownDelay += 100
                    it.copy(animationDuration = lastKnownDelay)
                }
            )
        }
    }
}