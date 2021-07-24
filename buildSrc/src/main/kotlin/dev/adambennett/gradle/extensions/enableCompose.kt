package dev.adambennett.gradle.extensions

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

fun BaseAppModuleExtension.enableCompose(version: String) {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = version
    }
}
