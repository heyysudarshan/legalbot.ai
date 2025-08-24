package legalbot.user.onboarding.presentation.languagePage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
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

    private var animationJob: Job? = null

    init {
        viewModelScope.launch {
            languageUseCase.getLanguages().collect { languages ->
                uiState.collect { value ->
                    value.copy(languages = languages)
                }
            }
        }
    }

    fun updateSelectedLanguage(language: Language) {
        languageUseCase.updateSelectedLanguage(language = language)
    }

    fun startAnimationJob() {
        animationJob = viewModelScope.launch {
            val totalLanguagesCount = uiState.value.languages.size
            var animationJobProgress = 0L

            repeat(times = totalLanguagesCount) {
                uiState.update { value ->
                    animationJobProgress += 100L
                    value.copy(animationJobProgress = animationJobProgress)
                }
                delay(100L)
            }
        }
        animationJob?.cancel()
    }
}