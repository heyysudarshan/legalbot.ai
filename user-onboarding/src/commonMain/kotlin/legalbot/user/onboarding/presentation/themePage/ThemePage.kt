package legalbot.user.onboarding.presentation.themePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
    userOnboardingNavController: NavController,
    modifier: Modifier = Modifier
) {
    val themePageViewModel = koinViewModel<ThemePageViewModel>()
    Column(modifier = modifier) {
        HeadingAndMessage(
            heading = Res.string.theme_page_heading,
            message = Res.string.theme_page_message,
            modifier = Modifier.headingAndMessageModifier()
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            ThemeList(
                themePageViewModel = themePageViewModel,
                modifier = Modifier.fillMaxSize()
            )
            BottomButtonAndContainer(
                label = Res.string.continue_button_label,
                modifier = Modifier.bottomButtonAndContainerModifier()
                    .align(alignment = Alignment.BottomEnd),
                onClick = {

                }
            )
        }
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
            userOnboardingNavController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}