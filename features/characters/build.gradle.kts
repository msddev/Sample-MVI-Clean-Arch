import extensions.*

plugins {
    androidCommonFeature
    androidCommonCompose
    androidCommonHilt
    ksp
}

android {
    namespace = "com.example.characters"
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "characters")
}

dependencies {
    LIBRARY_FRAMEWORK
    LIBRARY_SAMPLE_FRAMEWORK
    COMMON_PROVIDER
    COMMON_THEME
    COMMON_COMPONENT
    DATA_MODEL
    DOMAIN

    // Navigation
    implementation(NavigationLibs.navigation)
    implementation(NavigationLibs.destination_core)
    ksp(NavigationLibs.destination_ksp)
    implementation(NavigationLibs.destination_animation)

    implementation(ComposeLibs.material_icon_core)
    implementation(ComposeLibs.material_icon_extended)

    // Paging
    implementation(SupportLibs.paging)
    implementation(ComposeLibs.paging)

    implementation(ComposeLibs.coil)
}