package legalbot.user.onboarding.di

import legalbot.user.onboarding.data.local.language.LanguageLocalDataSourceImpl
import legalbot.user.onboarding.data.repository.LanguageRepositoryImpl
import legalbot.user.onboarding.domain.useCase.LanguageUseCase
import org.koin.dsl.module

val userOnboardingModule = module {
    single { LanguageLocalDataSourceImpl() }
    single { LanguageRepositoryImpl(get()) }
    single { LanguageUseCase(get()) }
}