package commons

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    addComposeConfig()
}

dependencies {
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:${DependencyVersions.compose_version}")
    implementation("androidx.compose.ui:ui-tooling-preview:${DependencyVersions.compose_version}")
    implementation("androidx.compose.material3:material3:1.1.0-alpha05")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${DependencyVersions.compose_version}")
    debugImplementation("androidx.compose.ui:ui-tooling:${DependencyVersions.compose_version}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${DependencyVersions.compose_version}")
}