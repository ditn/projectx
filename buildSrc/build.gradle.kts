@file:Suppress("UnstableApiUsage")

plugins {
    `kotlin-dsl`
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

dependencies {

    compileOnly(libs.android.gradleApi)
    compileOnly(libs.gradle.experimental)

    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
    implementation(libs.ktlintPlugin)
}

gradlePlugin {
    plugins {
        create("projectConfiguration") {
            id = "dev.adambennett.gradle.plugins.ProjectConfigurationPlugin"
            implementationClass = "dev.adambennett.gradle.plugins.ProjectConfigurationPlugin"
        }
    }
}
