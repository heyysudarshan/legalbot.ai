package legalbot.user.onboarding.repository.language

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.data.local.language.LanguageLocalDataSource
import legalbot.user.onboarding.domain.model.language.Language

internal class LanguageRepositoryImpl(
    private val localDataSource: LanguageLocalDataSource
) : LanguageRepository {
    override fun getLanguages(): StateFlow<List<Language>> {
        return localDataSource.getLanguages()
    }

    override fun updateSelectedLanguage(language: Language) {
        localDataSource.updateSelectedLanguage(language = language)
    }
}