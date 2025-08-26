import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

group = libs.versions.userOnboarding.group.get()
version = libs.versions.userOnboarding.version.get()

kotlin {
    androidTarget()

    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.koin.multiplatform)
            implementation(libs.kotlin.serialization.json)
            implementation(libs.bundles.compose.lifecycle)
            implementation(libs.bundles.compose.multiplatform)
            implementation(projects.shared)
        }
    }
}

compose.resources {
    generateResClass = never
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