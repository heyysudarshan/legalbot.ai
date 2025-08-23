package legalbot.compose.app

import androidx.compose.ui.window.ComposeUIViewController
import legalbot.compose.app.composeApp.di.initKoin

fun IosApp() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    ComposeApp()
}