package compose.app.shared.di

import org.koin.core.module.Module

internal expect fun getPlatformModule(): Module

val platformModule = getPlatformModule()