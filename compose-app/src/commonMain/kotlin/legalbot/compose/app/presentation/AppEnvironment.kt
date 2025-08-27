package legalbot.compose.app.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.key
import compose.app.shared.presentation.composeApp.customAppLocale
import compose.app.shared.util.LocaleManager

@Composable
fun AppEnvironment(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocaleManager provides customAppLocale
    ) {
        key(customAppLocale) {
            content()
        }
    }
}