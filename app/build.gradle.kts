import com.android.build.api.dsl.ManagedVirtualDevice
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

    enableCompose(project.libs.versions.compose.get())

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    testOptions {
        devices {
            register<ManagedVirtualDevice>("pixel2api30") {
                device = "Pixel 2"
                apiLevel = 30
                systemImageSource = "aosp-atd"
                abi = "arm64-v8a"
            }
        }
    }
}

dependencies {
    implementation(project(":ui"))

    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.bundles.androidx.compose)
    implementation(libs.androidx.composeNavigation)

    debugImplementation(libs.testing.compose.manifest)

    testImplementation(libs.testing.junit)

    androidTestImplementation(libs.testing.androidx.junit)
    androidTestImplementation(libs.testing.androidx.core)
    androidTestImplementation(libs.testing.espresso.core)
}
