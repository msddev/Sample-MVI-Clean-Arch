import extensions.*

plugins {
    androidCommonFeature
    androidCommonHilt
}

android {
    namespace = "com.example.splash"
}

dependencies {
    LIBRARY_FRAMEWORK
    DOMAIN

    implementation(SupportLibs.splash_screen)
}