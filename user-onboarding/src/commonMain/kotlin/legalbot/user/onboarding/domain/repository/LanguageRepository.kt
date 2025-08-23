package legalbot.user.onboarding.domain.repository

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.Language

internal interface LanguageRepository {
    fun getLanguages(): StateFlow<List<Language>>
    fun updateSelectedLanguage(language: Language)
}