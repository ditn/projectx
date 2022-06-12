plugins {
    kotlin("jvm")
}

dependencies {

    implementation(project(":feed:domain"))

    implementation(libs.javaxInject)
}
