plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

group = libs.versions.shared.group.get()
version = libs.versions.shared.version.get()

kotlin {
    androidTarget()

    jvm()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlin.serialization.json)
            implementation(libs.bundles.compose.multiplatform)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = libs.versions.shared.packageOfResClass.get()
}

android {
    namespace = libs.versions.shared.androidLibrary.namespace.get()
    compileSdk = libs.versions.shared.androidLibrary.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.shared.androidLibrary.minSdk.get().toInt()
    }
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/Shared"))