package legalbot.user.onboarding.domain.repository

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.Theme

internal interface ThemeRepository {
    fun getThemes() : StateFlow<List<Theme>>
    fun updateSelectedTheme(theme: Theme)
}