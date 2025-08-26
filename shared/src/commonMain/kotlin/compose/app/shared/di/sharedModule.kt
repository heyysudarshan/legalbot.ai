package compose.app.shared.di

import compose.app.shared.presentation.composeApp.ComposeAppViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val sharedModule = module {
    viewModelOf(::ComposeAppViewModel)
}