package compose.app.shared.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import java.util.Locale

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual object LocaleManager {
    private var defaultLocale: Locale? = null
    private var localAppLocale = staticCompositionLocalOf { Locale.getDefault().toString() }

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        if (defaultLocale == null) {
            defaultLocale = Locale.getDefault()
        }

        val newLocale = when (value) {
            null -> defaultLocale!!
            else -> {
                Locale.forLanguageTag(value)
            }
        }

        Locale.setDefault(newLocale)
        return localAppLocale.provides(newLocale.toString())
    }
}