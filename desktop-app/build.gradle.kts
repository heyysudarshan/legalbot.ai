import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.hot.reload)
}

group = libs.versions.desktopApp.group.get()
version = libs.versions.desktopApp.version.get()

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

dependencies {
    implementation(libs.kotlin.coroutines.swing)
    implementation(compose.desktop.currentOs)
    implementation(projects.composeApp)
}

compose.desktop {
    application {
        mainClass = libs.versions.desktopApp.mainClass.get()
    }
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/DesktopApp"))