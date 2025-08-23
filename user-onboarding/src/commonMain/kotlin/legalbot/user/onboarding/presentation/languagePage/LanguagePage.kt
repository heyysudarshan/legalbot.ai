package legalbot.user.onboarding.presentation.languagePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.app.shared.presentation.theme.ComposeAppTheme
import compose.app.shared.resources.Res
import compose.app.shared.resources.language_page_heading
import compose.app.shared.resources.language_page_message
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun LanguagePage(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        HeadingAndMessage(modifier = Modifier.headingAndMessageModifier())
    }
}

@Composable
private fun HeadingAndMessage(modifier: Modifier = Modifier) {
    val heading = stringResource(resource = Res.string.language_page_heading)
    val message = stringResource(resource = Res.string.language_page_message)

    Column(modifier = modifier) {
        Text(
            text = heading,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineMedium
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

private fun Modifier.headingAndMessageModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 60.dp, bottom = 20.dp)
}
@Preview
@Composable
private fun LanguagePagePreview() {
    ComposeAppTheme {
        LanguagePage()
    }
}