package compose.app.shared.presentation.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed class ComposeAppRoutes {
    @Serializable @SerialName("user-onboarding")
    object UserOnboardingModule : ComposeAppRoutes()
}