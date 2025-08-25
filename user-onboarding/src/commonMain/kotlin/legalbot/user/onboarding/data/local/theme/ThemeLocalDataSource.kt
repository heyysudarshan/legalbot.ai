package legalbot.user.onboarding.data.local.theme

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.Theme

internal interface ThemeLocalDataSource {
    suspend fun getThemes(): StateFlow<List<Theme>>
    fun updateSelectedTheme(theme: Theme)
}