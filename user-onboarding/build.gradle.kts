plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.userOnboarding.group.get()
version = libs.versions.userOnboarding.version.get()

kotlin {
    androidTarget()

    jvm("desktop")

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.multiplatform.ui)
            implementation(libs.compose.multiplatform.preview)
        }
    }
}

android {
    namespace = libs.versions.userOnboarding.androidLibrary.namespace.get()
    compileSdk = libs.versions.userOnboarding.androidLibrary.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.userOnboarding.androidLibrary.minSdk.get().toInt()
    }
}
// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/UserOnboarding"))