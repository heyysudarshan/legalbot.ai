package legalbot.user.onboarding.presentation.languagePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import legalbot.user.onboarding.domain.model.language.Language
import legalbot.user.onboarding.domain.useCase.language.LanguageUseCase

internal class LanguagePageViewModel(private val languageUseCase: LanguageUseCase) : ViewModel() {
    var uiState = MutableStateFlow(value = LanguagePageUiState())
        private set

    init {
        viewModelScope.launch {
            languageUseCase.getLanguages().collect { languages ->
                uiState.update { value ->
                    value.copy(languages = languages)
                }
            }
        }
    }

    fun updateSelectedLanguage(language: Language) {
        languageUseCase.updateSelectedLanguage(language = language)
    }
}