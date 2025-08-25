package legalbot.user.onboarding.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import compose.app.shared.presentation.theme.ComposeAppTheme
import compose.app.shared.resources.Res
import compose.app.shared.resources.next_button_label
import legalbot.user.onboarding.presentation.extensions.bottomButtonAndContainerModifier
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
private fun BottomButtonAndContainer(
    label: StringResource,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(100.dp),
            contentPadding = PaddingValues(all = 0.dp),
            modifier = Modifier.align(alignment = Alignment.CenterEnd),
            onClick = onClick,
        ) {
            Text(
                text = stringResource(resource = label),
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 34.dp, vertical = 20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun NextButtonAndContainerPreview() {
    ComposeAppTheme {
        val label = Res.string.next_button_label
        BottomButtonAndContainer(
            label = label,
            modifier = Modifier.bottomButtonAndContainerModifier(),
            onClick = {}
        )
    }
}