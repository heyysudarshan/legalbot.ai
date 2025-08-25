package legalbot.user.onboarding.presentation.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

internal fun Modifier.headingAndMessageModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 60.dp, bottom = 20.dp)
}

internal fun Modifier.nextButtonAndContainerModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(all = 20.dp)
}