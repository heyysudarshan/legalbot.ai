package legalbot.user.onboarding.di

import legalbot.user.onboarding.data.local.language.LanguageLocalDataSource
import legalbot.user.onboarding.data.local.language.LanguageLocalDataSourceImpl
import legalbot.user.onboarding.data.repository.LanguageRepositoryImpl
import legalbot.user.onboarding.domain.repository.LanguageRepository
import legalbot.user.onboarding.domain.useCase.LanguageUseCase
import legalbot.user.onboarding.presentation.languagePage.LanguagePageViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val userOnboardingModule = module {
    singleOf(::LanguageLocalDataSourceImpl).bind<LanguageLocalDataSource>()
    singleOf(::LanguageRepositoryImpl).bind<LanguageRepository>()
    singleOf(::LanguageUseCase)
    viewModelOf(::LanguagePageViewModel)
}