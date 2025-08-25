package legalbot.user.onboarding.domain.useCase

import kotlinx.coroutines.flow.StateFlow
import legalbot.user.onboarding.domain.model.Theme
import legalbot.user.onboarding.domain.repository.ThemeRepository

internal class ThemeUseCase(
    private val repository: ThemeRepository
) {
    fun getThemes(): StateFlow<List<Theme>> {
        return repository.getThemes()
    }

    fun updateSelectedTheme(theme: Theme) {
        repository.updateSelectedTheme(theme = theme)
    }
}