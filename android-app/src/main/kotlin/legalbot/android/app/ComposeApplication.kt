package legalbot.android.app

import android.app.Application
import legalbot.compose.app.composeApp.di.initKoin
import org.koin.android.ext.koin.androidContext

class ComposeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@ComposeApplication)
        }
    }
}