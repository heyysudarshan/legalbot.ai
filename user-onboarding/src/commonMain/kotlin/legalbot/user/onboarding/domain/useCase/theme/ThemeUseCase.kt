package legalbot.user.onboarding.domain.useCase.theme

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.theme.Theme
import legalbot.user.onboarding.repository.theme.ThemeRepository

internal class ThemeUseCase(
    private val repository: ThemeRepository
) {
    suspend fun getThemes(): StateFlow<List<Theme>> {
        return repository.getThemes()
    }

    fun updateSelectedTheme(theme: Theme) {
        repository.updateSelectedTheme(theme = theme)
    }
}