package legalbot.compose.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import compose.app.shared.presentation.navigation.ComposeAppRoutes
import legalbot.user.onboarding.presentation.navigation.UserOnboardingNavigation

@Composable
fun ComposeAppNavigation(onAllNavHostsReady: @Composable (List<NavHostController>) -> Unit = {}) {
    val composeAppNavController = rememberNavController()
    val navigationControllers = mutableListOf(composeAppNavController)

    NavHost(
        navController = composeAppNavController,
        startDestination = ComposeAppRoutes.UserOnboardingModule
    ) {
        composable<ComposeAppRoutes.UserOnboardingModule> {
            UserOnboardingNavigation(
                onNavHostReady = {
                    navigationControllers.add(element = it)
                }
            )
        }
    }

    onAllNavHostsReady(navigationControllers)
}