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

    implementation(ComposeLibs.material_icon_core)
    implementation(ComposeLibs.material_icon_extended)
    implementation(ComposeLibs.lottie)

}