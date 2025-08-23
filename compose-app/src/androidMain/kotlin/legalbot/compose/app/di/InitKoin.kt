package legalbot.compose.app.di

import legalbot.user.onboarding.di.userOnboardingModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(userOnboardingModule)
    }
}