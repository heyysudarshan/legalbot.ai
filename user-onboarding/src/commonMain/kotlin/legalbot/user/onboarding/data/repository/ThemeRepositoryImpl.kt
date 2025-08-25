package legalbot.user.onboarding.data.repository

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.data.local.theme.ThemeLocalDataSource
import legalbot.user.onboarding.domain.model.Theme

internal class ThemeRepositoryImpl(
    private val localDataSource: ThemeLocalDataSource
) {
    fun getThemes(): StateFlow<List<Theme>> {
        return localDataSource.getThemes()
    }

    fun updateSelectedTheme(theme: Theme) {
        localDataSource.updateSelectedTheme(theme = theme)
    }
}