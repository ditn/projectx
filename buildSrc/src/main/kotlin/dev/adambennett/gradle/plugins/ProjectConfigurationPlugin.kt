package dev.adambennett.gradle.plugins

import dev.adambennett.gradle.extensions.configureForRootProject
import dev.adambennett.gradle.extensions.configureKapt
import dev.adambennett.gradle.extensions.configureCommonAndroidOptions
import dev.adambennett.gradle.extensions.configureForAllProjects
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.TestedExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin

class ProjectConfigurationPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.configureForAllProjects()

        if (project.isRoot) {
            project.configureForRootProject()
        }

        project.plugins.all {
            when (this) {
                is JavaPlugin,
                is JavaLibraryPlugin,
                -> {
                    project.extensions.getByType(JavaPluginExtension::class.java).apply {
                        sourceCompatibility = JavaVersion.VERSION_11
                        targetCompatibility = JavaVersion.VERSION_11
                    }
                }
                is LibraryPlugin -> project.extensions.getByType<TestedExtension>()
                    .configureCommonAndroidOptions()
                is AppPlugin -> project.extensions.getByType<TestedExtension>()
                    .configureCommonAndroidOptions()
                is Kapt3GradleSubplugin -> project.configureKapt()
            }
        }
    }
}

val Project.isRoot get() = this == this.rootProject
