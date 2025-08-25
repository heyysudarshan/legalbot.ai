package legalbot.user.onboarding.presentation.themePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import compose.app.shared.presentation.theme.ComposeAppTheme
import compose.app.shared.resources.Res
import compose.app.shared.resources.theme_page_heading
import compose.app.shared.resources.theme_page_message
import legalbot.user.onboarding.presentation.components.HeadingAndMessage
import legalbot.user.onboarding.presentation.extensions.headingAndMessageModifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun ThemePage(
    userOnboardingNavController: NavController,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        HeadingAndMessage(
            heading = Res.string.theme_page_heading,
            message = Res.string.theme_page_message,
            modifier = Modifier.headingAndMessageModifier()
        )
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