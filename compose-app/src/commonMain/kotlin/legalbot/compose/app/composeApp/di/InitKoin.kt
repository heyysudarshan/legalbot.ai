package legalbot.compose.app.composeApp.di

import legalbot.user.onboarding.di.userOnboardingModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(userOnboardingModule)
    }
}