package compose.app.shared.presentation.navigation

import kotlinx.serialization.Serializable

sealed class ComposeAppRoutes {
    @Serializable
    object UserOnboardingModule : ComposeAppRoutes()
}