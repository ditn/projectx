package dev.adambennett.gradle.extensions

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

internal fun Project.configureKapt() {
    pluginManager.withPlugin("org.jetbrains.kotlin.kapt") {
        extensions.configure(KaptExtension::class.java) {
            correctErrorTypes = true
            javacOptions {
                option("-Xmaxerrs", 500)
            }
        }
    }
}
