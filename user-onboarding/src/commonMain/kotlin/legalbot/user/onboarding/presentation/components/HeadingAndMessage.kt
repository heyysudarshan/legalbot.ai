package legalbot.user.onboarding.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import compose.app.shared.resources.Res
import compose.app.shared.resources.language_page_heading
import compose.app.shared.resources.language_page_message
import legalbot.user.onboarding.presentation.extensions.headingAndMessageModifier
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun HeadingAndMessage(
    heading: StringResource,
    message: StringResource,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(resource = heading),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(resource = message),
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
private fun HeadingAndMessagePreview() {
    MaterialTheme {
        HeadingAndMessage(
            heading = Res.string.language_page_heading,
            message = Res.string.language_page_message,
            modifier = Modifier.headingAndMessageModifier()
        )
    }
}