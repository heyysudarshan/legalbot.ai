package legalbot.user.onboarding.data.local.language

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import legalbot.user.onboarding.domain.model.Language

internal class LanguageLocalDataSourceImpl : LanguageLocalDataSource {
    private val languageList = MutableStateFlow(
        listOf(
            Language(
                name = "English",
                message = "Use this app in English.",
                locale = "en",
                isSelected = true
            ),
            Language(
                name = "Marathi",
                message = "हे अ‍ॅप मराठीत वापरा.",
                locale = "mr",
                isSelected = false
            ),
            Language(
                name = "Hindi",
                message = "इस ऐप का उपयोग हिंदी में करें।",
                locale = "hi",
                isSelected = false
            ),
        )
    )

    override suspend fun getLanguages(): StateFlow<List<Language>> {
        return languageList
    }

    override fun updateSelectedLanguage(language: Language) {
        languageList.update { value ->
            value.map {
                if (it.locale == language.locale) {
                    language.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
        }
    }
}
