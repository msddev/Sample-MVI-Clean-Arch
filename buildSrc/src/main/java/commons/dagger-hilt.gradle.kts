package commons

import extensions.implementation
import extensions.kapt
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    // Dagger Hilt
    implementation(DaggerHiltLibs.android)
    kapt(DaggerHiltLibs.compiler)
    implementation(DaggerHiltLibs.compose)
}