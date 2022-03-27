package dev.adambennett.gradle.extensions

import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

internal fun Project.configureKtlintPlugin() {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    pluginManager.withPlugin("org.jlleitschuh.gradle.ktlint") {
        extensions.configure(KtlintExtension::class.java) {
            // TODO: Once Version Catalogues can be used in precompiled scripts, get version here
            version.set("0.45.1")
            android.set(true)
            outputToConsole.set(true)
            ignoreFailures.set(true)
            reporters {
                reporter(ReporterType.CHECKSTYLE)
                reporter(ReporterType.PLAIN)
            }
            filter {
                exclude("**/generated/**")
            }
        }
    }
}
