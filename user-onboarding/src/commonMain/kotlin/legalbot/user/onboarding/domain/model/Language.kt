package legalbot.user.onboarding.domain.model

internal data class Language(
    val name: String,
    val message: String,
    val locale: String,
    val isSelected: Boolean,
)