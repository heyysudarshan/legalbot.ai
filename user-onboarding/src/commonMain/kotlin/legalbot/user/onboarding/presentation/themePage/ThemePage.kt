package legalbot.user.onboarding.presentation.themePage

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
import compose.app.shared.resources.continue_button_label
import compose.app.shared.resources.theme_page_heading
import compose.app.shared.resources.theme_page_message
import legalbot.user.onboarding.presentation.components.BottomButtonAndContainer
import legalbot.user.onboarding.presentation.components.HeadingAndMessage
import legalbot.user.onboarding.presentation.extensions.bottomButtonAndContainerModifier
import legalbot.user.onboarding.presentation.extensions.headingAndMessageModifier
import legalbot.user.onboarding.presentation.themePage.component.ThemeCard
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun ThemePage(
    userOnboardingNavHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val themePageViewModel = koinViewModel<ThemePageViewModel>()
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

            ThemePageLayout(
                isMobileLandscapeMode = true,
                themePageViewModel = themePageViewModel,
                userOnBoardingNavHostController = userOnboardingNavHostController,
                modifier = modifier1,
                modifier2 = modifier2,
            )
        }
    } else {
        Column(modifier = modifier) {
            ThemePageLayout(
                isMobileLandscapeMode = false,
                themePageViewModel = themePageViewModel,
                userOnBoardingNavHostController = userOnboardingNavHostController,
                modifier = Modifier.fillMaxWidth(),
                modifier2 = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ThemePageLayout(
    isMobileLandscapeMode: Boolean,
    themePageViewModel: ThemePageViewModel,
    userOnBoardingNavHostController: NavHostController,
    modifier: Modifier = Modifier,
    modifier2: Modifier = Modifier
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
            heading = Res.string.theme_page_heading,
            message = Res.string.theme_page_message,
            modifier = backgroundModifier
        )
    }
    Box(modifier = modifier2) {
        val themeListModifier = if (isMobileLandscapeMode) {
            Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.Center)
        } else {
            Modifier
                .fillMaxSize()
        }
        val bottomButtonAndContainerModifier = Modifier.bottomButtonAndContainerModifier()
            .align(alignment = Alignment.BottomEnd)

        ThemeList(themePageViewModel = themePageViewModel, modifier = themeListModifier)
        BottomButtonAndContainer(
            label = Res.string.continue_button_label,
            modifier = bottomButtonAndContainerModifier,
            onClick = {

            }
        )
    }
}

@Composable
private fun ThemeList(
    themePageViewModel: ThemePageViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = themePageViewModel.uiState.collectAsStateWithLifecycle()
    val themes = uiState.value.themes

    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = themes) { theme ->
            ThemeCard(
                theme = theme,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    themePageViewModel.updateSelectedTheme(theme = theme)
                }
            )
        }
    }
}

@Preview
@Composable
private fun ThemePagePreview() {
    ComposeAppTheme {
        ThemePage(
            userOnboardingNavHostController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}