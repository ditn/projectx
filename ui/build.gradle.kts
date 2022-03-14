import dev.adambennett.gradle.extensions.enableCompose

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "dev.adambennett.ui"

    enableCompose(project.libs.versions.compose.get())
}

dependencies {

    implementation(libs.material)
    implementation(libs.bundles.androidx.compose)

    androidTestImplementation(libs.testing.compose.ui)
}


