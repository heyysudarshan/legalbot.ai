package compose.app.shared.util

import java.util.Locale

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class LocaleManager {
    actual fun setLocale(locale: String) {
        Locale.setDefault(Locale.of(locale))
    }
}