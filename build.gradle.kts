buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.android.gradle)
        classpath(libs.kotlin.gradle)
        classpath(libs.jlleitschuhKtlint)
    }
}

plugins {
    id("dev.adambennett.gradle.plugins.ProjectConfigurationPlugin")
}

subprojects {
    apply(plugin = "dev.adambennett.gradle.plugins.ProjectConfigurationPlugin")
}
