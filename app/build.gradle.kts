import dev.adambennett.gradle.extensions.enableCompose

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    defaultConfig {
        applicationId = "dev.adambennett.projectx"
        versionCode = 1
        versionName = "0.1"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // TODO: This is a bit of a hack while I wait for Gradle 7.2
    enableCompose(project.libs.versions.compose.get())
}

dependencies {
    implementation(libs.androidx.activity)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.material)
    implementation(libs.bundles.androidx.compose)

    debugImplementation(libs.testing.compose.manifest)

    testImplementation(libs.testing.junit)

    androidTestImplementation(libs.testing.androidx.junit)
    androidTestImplementation(libs.testing.espresso.core)
    androidTestImplementation(libs.testing.compose.ui)
}
