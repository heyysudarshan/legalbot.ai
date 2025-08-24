package legalbot.user.onboarding.presentation.languagePage

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import compose.app.shared.presentation.theme.ComposeAppTheme
import compose.app.shared.resources.Res
import compose.app.shared.resources.language_page_heading
import compose.app.shared.resources.language_page_message
import compose.app.shared.resources.next_button_label
import legalbot.user.onboarding.presentation.languagePage.components.LanguageCard
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun LanguagePage(modifier: Modifier = Modifier) {
    val languagePageViewModel = koinViewModel<LanguagePageViewModel>()
    Column(modifier = modifier) {
        HeadingAndMessage(modifier = Modifier.headingAndMessageModifier())
        Box(modifier = Modifier.fillMaxWidth()) {
            LanguageList(
                languagePageViewModel = languagePageViewModel,
                modifier = Modifier.fillMaxSize()
            )
            NextButtonAndContainer(
                modifier = Modifier
                    .nextButtonAndContainerModifier()
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
private fun HeadingAndMessage(modifier: Modifier = Modifier) {
    val heading = stringResource(resource = Res.string.language_page_heading)
    val message = stringResource(resource = Res.string.language_page_message)

    Column(modifier = modifier) {
        Text(
            text = heading,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = message,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium
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
    val animationJobProgress = uiState.value.animationJobProgress

    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = languages) { language ->
            val showContent = animationJobProgress == language.animationDuration
            AnimatedVisibility(visible = showContent) {
                LanguageCard(
                    language = language,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        languagePageViewModel.updateSelectedLanguage(language = language)
                    }
                )
            }
        }
    }
}

@Composable
private fun NextButtonAndContainer(modifier: Modifier = Modifier) {
    val buttonLabel = stringResource(resource = Res.string.next_button_label)

    Box(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(100.dp),
            contentPadding = PaddingValues(all = 0.dp),
            modifier = Modifier.align(alignment = Alignment.CenterEnd),
            onClick = {
                TODO()
            },
        ) {
            Text(
                text = buttonLabel,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 34.dp, vertical = 20.dp)
            )
        }
    }
}

private fun Modifier.headingAndMessageModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 60.dp, bottom = 20.dp)
}

private fun Modifier.nextButtonAndContainerModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(all = 20.dp)
}

@Preview
@Composable
private fun LanguagePagePreview() {
    ComposeAppTheme {
        LanguagePage()
    }
}