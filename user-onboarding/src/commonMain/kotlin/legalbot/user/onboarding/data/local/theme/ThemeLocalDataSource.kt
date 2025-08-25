package legalbot.user.onboarding.data.local.theme

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.Theme

internal interface ThemeLocalDataSource {
    fun getThemes(): StateFlow<List<Theme>>
    fun updateSelectedTheme(theme: Theme)
}