import extensions.DATA_MODEL
import extensions.LIBRARY_FRAMEWORK
import extensions.implementation

plugins {
    androidCommonLibrary
    androidCommonHilt
    ksp
}

android {
    namespace = "com.example.remote"
}

dependencies {
    LIBRARY_FRAMEWORK
    DATA_MODEL

    implementation(NetworkLibs.retrofit)
    implementation(NetworkLibs.retrofit_moshi)
    implementation(NetworkLibs.logging_interceptor)
    debugImplementation(NetworkLibs.chucker_debug)
    releaseImplementation(NetworkLibs.chucker_release)
}