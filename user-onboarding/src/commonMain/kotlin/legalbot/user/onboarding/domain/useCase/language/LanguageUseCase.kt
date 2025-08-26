package legalbot.user.onboarding.domain.useCase.language

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.language.Language
import legalbot.user.onboarding.repository.language.LanguageRepository

internal class LanguageUseCase(
    private val repository: LanguageRepository
) {
    suspend fun getLanguages(): StateFlow<List<Language>> {
        return repository.getLanguages()
    }

    fun updateSelectedLanguage(language: Language) {
        repository.updateSelectedLanguage(language = language)
    }
}