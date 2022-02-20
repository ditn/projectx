dependencyResolutionManagement {
    versionCatalogs {
        register("libs") {
            from(files("../gradle/libs.toml"))
        }
    }

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}
