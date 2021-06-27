@file:Suppress("UnstableApiUsage")

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("gradle/libs.toml"))
        }
    }

    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "projectx"

include(":app")
