package legalbot.user.onboarding.presentation.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal sealed class UserOnboardingRoutes {
    @Serializable @SerialName("select-language")
    object LanguagePage : UserOnboardingRoutes()

    @Serializable @SerialName("select-theme")
    object ThemPage : UserOnboardingRoutes()
}