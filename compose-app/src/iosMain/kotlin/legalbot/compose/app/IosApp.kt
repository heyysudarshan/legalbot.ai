package legalbot.compose.app

import androidx.compose.ui.window.ComposeUIViewController
import legalbot.compose.app.di.initKoin
import legalbot.compose.app.presentation.ComposeApp

fun IosApp() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    ComposeApp()
}