package legalbot.user.onboarding.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import legalbot.user.onboarding.presentation.languagePage.LanguagePage
import legalbot.user.onboarding.presentation.themePage.ThemePage

@Composable
fun UserOnboardingNavigation() {
    val userOnboardingNavController = rememberNavController()

    NavHost(
        navController = userOnboardingNavController,
        startDestination = UserOnboardingRoutes.LanguagePage
    ) {
        composable<UserOnboardingRoutes.LanguagePage> {
            LanguagePage(modifier = Modifier.fillMaxSize())
        }
        composable<UserOnboardingRoutes.ThemPage> {
            ThemePage(modifier = Modifier.fillMaxSize())
        }
    }
}