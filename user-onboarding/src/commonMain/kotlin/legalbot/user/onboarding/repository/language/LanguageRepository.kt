package legalbot.user.onboarding.repository.language

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.language.Language

internal interface LanguageRepository {
    fun getLanguages(): StateFlow<List<Language>>
    fun updateSelectedLanguage(language: Language)
}