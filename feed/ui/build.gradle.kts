import org.jetbrains.compose.compose

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose") version libs.versions.jetbrainsCompose
}

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm()
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.preview)
                implementation(compose.runtime)
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation(libs.bundles.androidx.compose)
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.macos_arm64)
            }
        }
    }
}

android {
    namespace = "dev.adambennett.feed.ui"

    dependencies {
        debugImplementation(libs.androidx.composeUiTooling)
    }
}

compose.desktop {
    application {
//        mainClass = "MainKt"
    }
}
