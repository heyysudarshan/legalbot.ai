package legalbot.user.onboarding.data.local.theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import legalbot.user.onboarding.domain.model.Theme
import legalbot.user.onboarding.domain.model.ThemeType

internal class LocalThemeDataSourceImpl : LocalThemeDataSource {
    private val themeList = MutableStateFlow(
        listOf(
            Theme(
                name = "System",
                message = "Use the system theme.",
                isSelected = true,
                type = ThemeType.System
            ),
            Theme(
                name = "Light",
                message = "Use a light theme.",
                isSelected = false,
                type = ThemeType.Light
            ),
            Theme(
                name = "Dark",
                message = "Use a dark theme.",
                isSelected = false,
                type = ThemeType.Dark
            )
        )
    )

    override fun getThemes(): StateFlow<List<Theme>> {
        return themeList
    }

    override fun updateSelectedTheme(theme: Theme) {
        themeList.update { value ->
            value.map {
                if (it.type == theme.type) {
                    theme.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
        }
    }
}