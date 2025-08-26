import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.composeApp.group.get()
version = libs.versions.composeApp.version.get()

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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.koin.multiplatform)
            implementation(libs.bundles.compose.lifecycle)
            implementation(libs.bundles.compose.multiplatform)
            implementation(projects.shared)
            implementation(projects.userOnboarding)
        }
    }
}

compose.resources {
    generateResClass = never
}

android {
    namespace = libs.versions.composeApp.androidLibrary.namespace.get()
    compileSdk = libs.versions.composeApp.androidLibrary.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.composeApp.androidLibrary.minSdk.get().toInt()
    }
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/ComposeApp"))