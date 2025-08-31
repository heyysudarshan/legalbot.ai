package legalbot.web.app

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToBrowserNavigation
import kotlinx.browser.document
import legalbot.compose.app.WebApp
import legalbot.compose.app.di.initKoin
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)
fun main() {
    initKoin()
    onWasmReady {
        val body = document.body ?: return@onWasmReady
        ComposeViewport(viewportContainer = body) {
            WebApp(
                onAllNavHostsReady = { navHostControllers ->
                    navHostControllers.forEach { navHostController ->
                        LaunchedEffect(Unit) {
                            navHostController.bindToBrowserNavigation()
                        }
                    }
                }
            )
        }
    }
}