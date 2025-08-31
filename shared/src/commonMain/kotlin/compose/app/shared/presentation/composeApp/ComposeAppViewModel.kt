package compose.app.shared.presentation.composeApp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ComposeAppViewModel : ViewModel() {
    var uiState = MutableStateFlow(value = ComposeAppUiState())
        private set

    fun updateDarkTheme(isDarkMode: Boolean) {
        uiState.update { value ->
            value.copy(isDarkMode = isDarkMode)
        }
    }
}