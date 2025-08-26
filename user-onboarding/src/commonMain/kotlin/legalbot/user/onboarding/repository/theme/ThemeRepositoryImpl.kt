package legalbot.user.onboarding.repository.theme

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.data.local.theme.ThemeLocalDataSource
import legalbot.user.onboarding.domain.model.theme.Theme

internal class ThemeRepositoryImpl(
    private val localDataSource: ThemeLocalDataSource
) : ThemeRepository {
    override suspend fun getThemes(): StateFlow<List<Theme>> {
        return localDataSource.getThemes()
    }

    override fun updateSelectedTheme(theme: Theme) {
        localDataSource.updateSelectedTheme(theme = theme)
    }
}