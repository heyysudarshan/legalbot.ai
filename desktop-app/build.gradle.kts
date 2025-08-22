import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.desktopApp.group.get()
version = libs.versions.desktopApp.version.get()

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of("21"))
    }
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin.compilerOptions {
    jvmTarget = JvmTarget.JVM_21
}

dependencies {
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