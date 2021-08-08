plugins {
    `kotlin-dsl`
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

dependencies {

    compileOnly(libs.android.gradleApi)
    compileOnly(libs.gradle.experimental)

    implementation(libs.kotlin.gradle)
    implementation(libs.android.gradle)
    implementation(libs.jlleitschuhKtlint)
}

gradlePlugin {
    plugins {
        register("projectConfiguration") {
            id = "dev.adambennett.gradle.plugins.ProjectConfigurationPlugin"
            implementationClass = "dev.adambennett.gradle.plugins.ProjectConfigurationPlugin"
        }
    }
}
