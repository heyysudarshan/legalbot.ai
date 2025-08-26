package legalbot.compose.app.composeApp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.app.shared.presentation.navigation.ComposeAppRoutes
import legalbot.user.onboarding.presentation.navigation.UserOnboardingNavigation

@Composable
fun ComposeAppNavigation() {
    val composeAppNavController = rememberNavController()

    NavHost(
        navController = composeAppNavController,
        startDestination = ComposeAppRoutes.UserOnboardingModule
    ) {
        composable<ComposeAppRoutes.UserOnboardingModule> {
            UserOnboardingNavigation()
        }
    }
}