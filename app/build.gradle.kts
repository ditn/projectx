import com.android.build.api.dsl.ManagedVirtualDevice
import dev.adambennett.gradle.extensions.enableCompose

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "dev.adambennett.projectx"

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

    enableCompose(project.libs.versions.composeCompiler.get())

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    testOptions {
        managedDevices.devices {
            register<ManagedVirtualDevice>("pixel2api30") {
                device = "Pixel 2"
                apiLevel = 30
                systemImageSource = "aosp-atd"
                require64Bit = true
            }
        }
    }
}

hilt {
    enableAggregatingTask = true
    enableExperimentalClasspathAggregation = true
}

dependencies {
    implementation(project(":ui"))
    implementation(project(":feed:wiring"))

    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.bundles.androidx.compose)
    implementation(libs.androidx.composeNavigation)

    implementation(libs.dagger.hilt.compose.navigation)
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.android.compiler)

    debugImplementation(libs.androidx.composeUiTooling)

    testImplementation(libs.testing.junit)

    androidTestImplementation(libs.testing.androidx.junit)
    androidTestImplementation(libs.testing.androidx.core)
    androidTestImplementation(libs.testing.espresso.core)
}
