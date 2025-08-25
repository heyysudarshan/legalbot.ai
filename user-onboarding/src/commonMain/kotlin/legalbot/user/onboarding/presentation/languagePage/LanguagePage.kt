package legalbot.user.onboarding.presentation.languagePage

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
    userOnBoardingNavController: NavController,
    modifier: Modifier = Modifier
) {
    val languagePageViewModel = koinViewModel<LanguagePageViewModel>()
    Column(modifier = modifier) {
        HeadingAndMessage(
            heading = Res.string.language_page_heading,
            message = Res.string.language_page_message,
            modifier = Modifier.headingAndMessageModifier()
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            LanguageList(
                languagePageViewModel = languagePageViewModel,
                modifier = Modifier.fillMaxSize()
            )
            BottomButtonAndContainer(
                label = Res.string.next_button_label,
                modifier = Modifier.bottomButtonAndContainerModifier()
                    .align(alignment = Alignment.BottomEnd),
                onClick = {
                    userOnBoardingNavController.navigate(UserOnboardingRoutes.ThemPage)
                }
            )
        }
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
                onClick = { languagePageViewModel.updateSelectedLanguage(language) }
            )
        }
    }
}

@Preview
@Composable
private fun LanguagePagePreview() {
    ComposeAppTheme {
        LanguagePage(
            userOnBoardingNavController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}