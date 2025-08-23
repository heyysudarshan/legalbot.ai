package legalbot.user.onboarding.data.repository

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.data.local.language.LanguageLocalDataSource
import legalbot.user.onboarding.domain.model.Language
import legalbot.user.onboarding.domain.repository.LanguageRepository

internal class LanguageRepositoryImpl(
    private val localLanguageDataSource: LanguageLocalDataSource
) : LanguageRepository {
    override fun getLanguages(): StateFlow<List<Language>> {
        return localLanguageDataSource.getLanguages()
    }

    override fun updateSelectedLanguage(language: Language) {
        localLanguageDataSource.updateSelectedLanguage(language = language)
    }
}