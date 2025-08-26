package legalbot.web.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import legalbot.compose.app.WebApp
import legalbot.compose.app.composeApp.di.initKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(viewportContainer = document.body!!) {
        initKoin()
        WebApp()
    }
}