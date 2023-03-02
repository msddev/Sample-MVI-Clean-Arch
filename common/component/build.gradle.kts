import extensions.*

plugins {
    androidCommonFeature
    androidCommonCompose
}

android {
    namespace = "com.example.component"
}

dependencies {
    COMMON_THEME
    LIBRARY_SAMPLE_FRAMEWORK

    implementation(ComposeLibs.lottie)
}