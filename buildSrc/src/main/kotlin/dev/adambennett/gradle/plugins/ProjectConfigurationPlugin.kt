package dev.adambennett.gradle.plugins

import dev.adambennett.gradle.extensions.configureForRootProject
import dev.adambennett.gradle.extensions.configureKapt
import dev.adambennett.gradle.extensions.configureCommonAndroidOptions
import dev.adambennett.gradle.extensions.configureForAllProjects
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.TestedExtension
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.SourceSet
import org.gradle.kotlin.dsl.closureOf
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin

class ProjectConfigurationPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.afterEvaluate {
            configureForAllProjects()

            if (project == rootProject) {
                configureForRootProject()
            }

            plugins.all {
                when (this) {
                    is JavaPlugin,
                    is JavaLibraryPlugin,
                    -> {
                        project.extensions.getByType(JavaPluginExtension::class.java).apply {
                            sourceCompatibility = JavaVersion.VERSION_1_8
                            targetCompatibility = JavaVersion.VERSION_1_8

                            sourceSets {
                                map { it.java.srcDir("src/${it.name}/kotlin") }
                            }
                        }
                    }
                    is LibraryPlugin -> extensions.getByType<TestedExtension>()
                        .configureCommonAndroidOptions()
                    is AppPlugin -> extensions.getByType<TestedExtension>()
                        .configureCommonAndroidOptions()
                    is Kapt3GradleSubplugin -> configureKapt()
                }
            }
        }
    }
}

private fun JavaPluginExtension.sourceSets(
    action: NamedDomainObjectContainer<SourceSet>.() -> Unit,
) {
    sourceSets(closureOf<NamedDomainObjectContainer<SourceSet>> { action() })
}
