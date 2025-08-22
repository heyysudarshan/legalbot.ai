plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = libs.versions.androidApp.androidApp.namespace.get()
    compileSdk = libs.versions.androidApp.androidApp.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.androidApp.androidApp.applicationId.get()
        minSdk = libs.versions.androidApp.androidApp.minSdk.get().toInt()
        targetSdk = libs.versions.androidApp.androidApp.targetSdk.get().toInt()
        versionCode = libs.versions.androidApp.androidApp.versionCode.get().toInt()
        versionName = libs.versions.androidApp.androidApp.versionName.get()
    }
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/AndroidApp"))