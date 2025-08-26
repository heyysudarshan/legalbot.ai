package legalbot.user.onboarding.domain.model.theme

internal data class Theme(
    val name: String,
    val message: String,
    val isSelected: Boolean,
    val type: ThemeType,
)