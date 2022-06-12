plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "dev.adambennett.feed.presentation"
}

hilt {
    enableAggregatingTask = true
    enableExperimentalClasspathAggregation = true
}

dependencies {

    implementation(project(":feed:ui"))
    implementation(project(":feed:domain"))

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.android.compiler)
}
