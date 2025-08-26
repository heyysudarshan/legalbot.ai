package legalbot.user.onboarding.presentation.languagePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import compose.app.shared.presentation.theme.ComposeAppTheme
import compose.app.shared.resources.Res
import compose.app.shared.resources.language_page_heading
import compose.app.shared.resources.language_page_message
import compose.app.shared.resources.next_button_label
import legalbot.user.onboarding.presentation.components.BottomButtonAndContainer
import legalbot.user.onboarding.presentation.components.HeadingAndMessage
import legalbot.user.onboarding.presentation.extensions.bottomButtonAndContainerModifier
import legalbot.user.onboarding.presentation.extensions.headingAndMessageModifier
import legalbot.user.onboarding.presentation.languagePage.components.LanguageCard
import legalbot.user.onboarding.presentation.navigation.UserOnboardingRoutes
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun LanguagePage(
    userOnBoardingNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val languagePageViewModel = koinViewModel<LanguagePageViewModel>()

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val windowWidth = windowSizeClass.windowWidthSizeClass
    val windowHeight = windowSizeClass.windowHeightSizeClass

    // Check if the display layout is in mobile landscape mode
    val isMobileLandscapeMode = windowWidth == WindowWidthSizeClass.EXPANDED
            && windowHeight in listOf(WindowHeightSizeClass.COMPACT, WindowHeightSizeClass.MEDIUM)

    if (isMobileLandscapeMode) {
        Row(modifier = modifier) {
            val modifier1 = Modifier
                .fillMaxHeight()
                .weight(0.8f)
            val modifier2 = Modifier
                .fillMaxHeight()
                .weight(1.2f)

            LandingPageLayout(
                isMobileLandscapeMode = true,
                languagePageViewModel = languagePageViewModel,
                userOnBoardingNavHostController = userOnBoardingNavHostController,
                modifier = modifier1,
                modifier2 = modifier2,
            )
        }
    } else {
        Column(modifier = modifier) {
            LandingPageLayout(
                isMobileLandscapeMode = false,
                languagePageViewModel = languagePageViewModel,
                userOnBoardingNavHostController = userOnBoardingNavHostController,
                modifier = Modifier.fillMaxWidth(),
                modifier2 = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun LandingPageLayout(
    isMobileLandscapeMode: Boolean,
    languagePageViewModel: LanguagePageViewModel,
    userOnBoardingNavHostController: NavHostController,
    modifier: Modifier = Modifier,
    modifier2: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        val backgroundModifier = if (isMobileLandscapeMode) {
            Modifier
                .headingAndMessageModifier(isMobileLandscapeMode = true)
                .align(alignment = Alignment.Center)
        } else {
            Modifier.headingAndMessageModifier()
        }
        HeadingAndMessage(
            heading = Res.string.language_page_heading,
            message = Res.string.language_page_message,
            modifier = backgroundModifier.align(alignment = Alignment.Center)
        )
    }
    Box(modifier = modifier2) {
        val languageListModifier = if (isMobileLandscapeMode) {
            Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.Center)
        } else {
            Modifier
                .fillMaxSize()
        }
        LanguageList(languagePageViewModel = languagePageViewModel, modifier = languageListModifier)
        BottomButtonAndContainer(
            label = Res.string.next_button_label,
            modifier = Modifier
                .bottomButtonAndContainerModifier()
                .align(alignment = Alignment.BottomEnd),
            onClick = {
                userOnBoardingNavHostController.navigate(UserOnboardingRoutes.ThemPage)
            }
        )
    }
}

@Composable
private fun LanguageList(
    languagePageViewModel: LanguagePageViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = languagePageViewModel.uiState.collectAsStateWithLifecycle()
    val languages = uiState.value.languages

    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = languages) { language ->
            LanguageCard(
                language = language,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    languagePageViewModel.updateSelectedLanguage(language)
                }
            )
        }
    }
}

@Preview
@Composable
private fun LanguagePagePreview() {
    ComposeAppTheme {
        LanguagePage(
            userOnBoardingNavHostController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}