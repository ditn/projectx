@file:Suppress("UnstableApiUsage")

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        val libs = project.extensions
            .getByType<VersionCatalogsExtension>()
            .named("libs") as org.gradle.accessors.dm.LibrariesForLibs

        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.ktlintPlugin)
    }
}

plugins {
    id("dev.adambennett.gradle.plugins.ProjectConfigurationPlugin")
}

subprojects {
    apply(plugin = "dev.adambennett.gradle.plugins.ProjectConfigurationPlugin")
}
