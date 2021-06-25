import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        // TODO: This won't be necessary in Gradle >7.1
//        val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs") as LibrariesForLibs

        val libs = the<LibrariesForLibs>()

        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.ktlintPlugin)
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
