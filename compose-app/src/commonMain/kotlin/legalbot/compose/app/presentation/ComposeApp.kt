package legalbot.compose.app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import compose.app.shared.presentation.composeApp.ComposeAppViewModel
import compose.app.shared.presentation.theme.ComposeAppTheme
import legalbot.compose.app.presentation.navigation.ComposeAppNavigation
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun ComposeApp(onAllNavHostsReady: @Composable (List<NavHostController>) -> Unit = {}) {
    val composeAppViewModel = koinViewModel<ComposeAppViewModel>()
    val uiState = composeAppViewModel.uiState.collectAsStateWithLifecycle()
    val isDarkMode = uiState.value.isDarkMode

    AppEnvironment {
        ComposeAppTheme(isDarkMode = isDarkMode) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                val backgroundModifier = Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize()
                    .padding(innerPadding)

                Box(modifier = backgroundModifier) {
                    ComposeAppNavigation(onAllNavHostsReady = onAllNavHostsReady)
                }
            }
        }
    }
}