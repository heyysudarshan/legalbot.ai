package legalbot.user.onboarding.domain.useCase

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.Language
import legalbot.user.onboarding.domain.repository.LanguageRepository

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