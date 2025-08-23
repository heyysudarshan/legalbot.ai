package legalbot.user.onboarding.data.local.language

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.Language

internal interface LanguageLocalDataSource {
    fun getLanguages(): StateFlow<List<Language>>
    fun updateSelectedLanguage(language: Language)
}