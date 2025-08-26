package legalbot.user.onboarding.repository.theme

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.theme.Theme

internal interface ThemeRepository {
    suspend fun getThemes(): StateFlow<List<Theme>>
    fun updateSelectedTheme(theme: Theme)
}