package legalbot.user.onboarding.presentation.languagePage

import legalbot.user.onboarding.domain.model.Language

internal data class LanguagePageUiState(
    val languages: List<Language> = emptyList(),
    val animationJobProgress: Long = 0L,
)