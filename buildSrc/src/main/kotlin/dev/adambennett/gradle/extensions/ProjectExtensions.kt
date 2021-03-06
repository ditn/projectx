package dev.adambennett.gradle.extensions

import com.android.build.gradle.TestedExtension
import dev.adambennett.gradle.constants.SharedVersions
import dev.adambennett.gradle.constants.additionalCompilerArgs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureForRootProject() {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    tasks.register("clean", Delete::class.java) {
        delete(rootProject.buildDir)
    }
}

internal fun Project.configureForAllProjects() {
    configureKtlintPlugin()

    repositories.apply {
        mavenCentral()
        google()
    }

    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_11.toString()
        targetCompatibility = JavaVersion.VERSION_11.toString()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + additionalCompilerArgs
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

    tasks.withType<Test>().configureEach {
        testLogging {
            events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        }
    }
}

internal fun TestedExtension.configureCommonAndroidOptions() {
    setCompileSdkVersion(SharedVersions.compileSdk)

    defaultConfig.apply {
        minSdk = SharedVersions.minSdk
        targetSdk = SharedVersions.targetSdk
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions.animationsDisabled = true

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

