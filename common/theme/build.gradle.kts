import extensions.*

plugins {
    androidCommonFeature
    androidCommonCompose
}

android {
    namespace = "com.example.theme"
}

dependencies {
    implementation(SupportLibs.splash_screen)
}