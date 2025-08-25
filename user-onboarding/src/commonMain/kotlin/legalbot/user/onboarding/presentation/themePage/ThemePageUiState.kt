package legalbot.user.onboarding.presentation.themePage

import legalbot.user.onboarding.domain.model.Theme

internal data class ThemePageUiState(
    val themes: List<Theme> = emptyList()
)