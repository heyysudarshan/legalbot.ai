package legalbot.user.onboarding.data.repository

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.data.local.theme.ThemeLocalDataSource
import legalbot.user.onboarding.domain.model.Theme
import legalbot.user.onboarding.domain.repository.ThemeRepository

internal class ThemeRepositoryImpl(
    private val localDataSource: ThemeLocalDataSource
): ThemeRepository {
    override fun getThemes(): StateFlow<List<Theme>> {
        return localDataSource.getThemes()
    }

    override fun updateSelectedTheme(theme: Theme) {
        localDataSource.updateSelectedTheme(theme = theme)
    }
}