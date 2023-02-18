import extensions.*

plugins {
    androidCommonFeature
    androidCommonHilt
}

android {
    namespace = "com.example.splash"
}

dependencies {
    FRAMEWORK
    DOMAIN

    implementation(SupportLibs.splash_screen)
}