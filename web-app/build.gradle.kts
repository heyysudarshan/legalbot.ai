plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.webApp.group.get()
version = libs.versions.webApp.version.get()

kotlin {
    wasmJs()
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/WebApp"))