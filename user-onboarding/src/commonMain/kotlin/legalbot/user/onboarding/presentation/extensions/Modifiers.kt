package legalbot.user.onboarding.presentation.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal fun Modifier.headingAndMessageModifier(isMobileLandscapeMode: Boolean = false): Modifier {
    val topPadding = if (isMobileLandscapeMode) 20.dp else 60.dp
    return this
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = topPadding, bottom = 20.dp)
}

internal fun Modifier.bottomButtonAndContainerModifier(): Modifier {
    return this
        .fillMaxWidth()
        .padding(all = 20.dp)
}

internal fun Modifier.desktopLayoutModifier(
    backgroundColor: Color,
    horizontalPadding: Dp,
    verticalPadding: Dp
): Modifier {
    return this
        .background(color = backgroundColor)
        .fillMaxSize()
        .padding(horizontal = horizontalPadding, vertical = verticalPadding)
        .clip(shape = RoundedCornerShape(size = 20.dp))
}

internal fun Modifier.commonLayoutModifier(backgroundColor: Color): Modifier {
    return this
        .background(color = backgroundColor)
        .padding(all = 20.dp)
        .fillMaxSize()
}