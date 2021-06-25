enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.toml"))
        }
    }

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
