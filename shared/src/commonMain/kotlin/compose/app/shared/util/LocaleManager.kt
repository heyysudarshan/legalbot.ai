package compose.app.shared.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object LocaleManager {
    @Composable
    infix fun provides(value: String?): ProvidedValue<*>
}