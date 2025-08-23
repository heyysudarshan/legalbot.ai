package legalbot.android.app

import android.app.Application
import legalbot.user.onboarding.di.userOnboardingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComposeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ComposeApplication)
            modules(
                userOnboardingModule
            )
        }
    }
}