import extensions.*

plugins {
    androidCommonFeature
    androidCommonCompose
    androidCommonHilt
    ksp
}

android {
    namespace = "com.example.welcome"
}

dependencies {
    // Modules
    FRAMEWORK
    SAMPLE_FRAMEWORK
    THEME

    // Navigation
    implementation(NavigationLibs.navigation)
    implementation(NavigationLibs.destination_core)
    ksp(NavigationLibs.destination_ksp)
    implementation(NavigationLibs.destination_animation)
}