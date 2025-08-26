package legalbot.desktop.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import legalbot.compose.app.DesktopApp
import legalbot.compose.app.composeApp.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            visible = true,
            onCloseRequest = ::exitApplication,
            title = "Legalbot",
        ) {
            DesktopApp()
        }
    }
}