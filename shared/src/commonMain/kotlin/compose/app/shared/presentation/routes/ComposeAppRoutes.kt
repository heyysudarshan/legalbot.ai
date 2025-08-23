package compose.app.shared.presentation.routes

import kotlinx.serialization.Serializable

sealed class ComposeAppRoutes {
    @Serializable
    object UserOnboardingModule : ComposeAppRoutes()
}