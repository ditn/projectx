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
        classpath(libs.hilt.gradle)
    }

    configurations.all {
        resolutionStrategy.eachDependency {
            when (requested.name) {
                // https://github.com/google/dagger/issues/3068
                "javapoet" -> useVersion("1.13.0")
            }
        }
    }
}

plugins {
    id("dev.adambennett.gradle.plugins.ProjectConfigurationPlugin")
}

subprojects {
    apply(plugin = "dev.adambennett.gradle.plugins.ProjectConfigurationPlugin")
}
