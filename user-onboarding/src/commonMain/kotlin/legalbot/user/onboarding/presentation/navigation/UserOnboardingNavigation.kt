package legalbot.user.onboarding.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import legalbot.user.onboarding.presentation.extensions.commonLayoutModifier
import legalbot.user.onboarding.presentation.extensions.desktopLayoutModifier
import legalbot.user.onboarding.presentation.languagePage.LanguagePage
import legalbot.user.onboarding.presentation.themePage.ThemePage

@Composable
fun UserOnboardingNavigation(onNavHostReady: (NavHostController) -> Unit = {}) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val windowWidth = windowSizeClass.windowWidthSizeClass
    val windowHeight = windowSizeClass.windowHeightSizeClass

    val userOnboardingNavHostController = rememberNavController()

    val isCurrentRouteNotLandingPage =
        userOnboardingNavHostController.currentDestination != UserOnboardingRoutes.LanguagePage
    val setExpanded by remember { mutableStateOf(value = isCurrentRouteNotLandingPage) }

    when {
        // Desktop breakpoint
        (windowWidth == WindowWidthSizeClass.EXPANDED && windowHeight == WindowHeightSizeClass.EXPANDED) && setExpanded -> {
            BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                val horizontalPadding = maxWidth * 0.34f
                val verticalPadding = maxHeight * 0.10f

                val backgroundColor = MaterialTheme.colorScheme.surfaceDim
                val backgroundModifier = Modifier.desktopLayoutModifier(
                    backgroundColor = backgroundColor,
                    horizontalPadding = horizontalPadding,
                    verticalPadding = verticalPadding
                )

                DesktopLayout(
                    userOnboardingNavHostController = userOnboardingNavHostController,
                    modifier = backgroundModifier
                )
            }
        }

        // Tablet breakpoint
        windowWidth == WindowWidthSizeClass.COMPACT && (windowHeight in listOf(
            WindowHeightSizeClass.COMPACT
        )) -> {
            BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                val horizontalPadding = maxWidth * 0.40f
                val backgroundModifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = horizontalPadding)
                Box(modifier = backgroundModifier) {
                    CommonLayout(
                        userOnboardingNavHostController = userOnboardingNavHostController,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        else -> {
            CommonLayout(
                userOnboardingNavHostController = userOnboardingNavHostController,
                modifier = Modifier.fillMaxSize()
            )
        }
    }

    onNavHostReady(userOnboardingNavHostController)
}

@Composable
private fun DesktopLayout(
    userOnboardingNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        val backgroundColor = MaterialTheme.colorScheme.background
        CommonLayout(
            userOnboardingNavHostController = userOnboardingNavHostController,
            modifier = Modifier.commonLayoutModifier(backgroundColor = backgroundColor)
        )
    }
}

@Composable
private fun CommonLayout(
    userOnboardingNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = userOnboardingNavHostController,
        startDestination = UserOnboardingRoutes.LanguagePage,
        modifier = modifier
    ) {
        composable<UserOnboardingRoutes.LanguagePage> {
            LanguagePage(
                userOnBoardingNavHostController = userOnboardingNavHostController,
                modifier = Modifier.fillMaxSize()
            )
        }
        composable<UserOnboardingRoutes.ThemPage> {
            ThemePage(
                userOnboardingNavHostController = userOnboardingNavHostController,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}