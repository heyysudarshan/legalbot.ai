package legalbot.user.onboarding.domain.model.theme

import compose.app.shared.domain.model.ThemeType

internal data class Theme(
    val name: String,
    val message: String,
    val isSelected: Boolean,
    val type: ThemeType,
)