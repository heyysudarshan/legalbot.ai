package legalbot.user.onboarding.presentation.themePage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import compose.app.shared.presentation.theme.ComposeAppTheme
import legalbot.user.onboarding.domain.model.Theme
import legalbot.user.onboarding.domain.model.ThemeType
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun ThemeCard(
    theme: Theme,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val commonModifier = Modifier.fillMaxWidth()
    val backgroundModifier = modifier
        .padding(horizontal = 20.dp)
        .background(color = MaterialTheme.colorScheme.surface)
        .clickable(onClick = onClick)
        .padding(vertical = 12.dp)

    Row(verticalAlignment = Alignment.CenterVertically, modifier = backgroundModifier) {
        RadioButton(selected = theme.isSelected, onClick = onClick)
        Spacer(modifier = Modifier.width(4.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = theme.name,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = commonModifier
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = theme.message,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                modifier = commonModifier
            )
        }
    }
}

@Preview
@Composable
private fun LanguageCardPreview() {
    ComposeAppTheme {
        val theme = Theme(
            name = "System",
            message = "Use the system theme.",
            isSelected = true,
            type = ThemeType.System
        )
        ThemeCard(theme = theme, modifier = Modifier.fillMaxWidth(), onClick = {})
    }
}