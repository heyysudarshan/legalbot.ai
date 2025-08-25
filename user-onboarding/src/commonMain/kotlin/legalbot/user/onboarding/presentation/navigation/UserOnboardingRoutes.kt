package legalbot.user.onboarding.presentation.navigation

import kotlinx.serialization.Serializable

internal sealed class UserOnboardingRoutes {
    @Serializable
    object LanguagePage : UserOnboardingRoutes()

    @Serializable
    object ThemPage : UserOnboardingRoutes()
}