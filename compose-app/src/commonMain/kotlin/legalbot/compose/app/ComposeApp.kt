package legalbot.compose.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.app.shared.presentation.theme.ComposeAppTheme
import legalbot.compose.app.composeApp.ComposeAppNavigation

@Composable
internal fun ComposeApp() {
    ComposeAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val backgroundModifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

            Surface(modifier = backgroundModifier) {
                ComposeAppNavigation()
            }
        }
    }
}