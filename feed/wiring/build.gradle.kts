plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "dev.adambennett.feed.wiring"
}

hilt {
    enableAggregatingTask = true
    enableExperimentalClasspathAggregation = true
}

dependencies {

    implementation(project(":feed:data"))
    implementation(project(":feed:domain"))
    implementation(project(":feed:presentation"))
    implementation(project(":feed:ui"))

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.android.compiler)
}
