import extensions.*

plugins {
    androidCommonFeature
    androidCommonCompose
    androidCommonHilt
    ksp
}

android {
    namespace = "com.example.home"
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "home")
}

dependencies {

    // Navigation
    implementation(NavigationLibs.navigation)
    implementation(NavigationLibs.destination_core)
    ksp(NavigationLibs.destination_ksp)
    implementation(NavigationLibs.destination_animation)
}