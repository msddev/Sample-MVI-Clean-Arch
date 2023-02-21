import extensions.*

plugins {
    androidCommonLibrary
    androidCommonHilt
}

android {
    namespace = "com.example.domain"
}

dependencies {
    LIBRARY_FRAMEWORK
    DATA_MODEL
    DATA_LOCAL
    DATA_REMOTE
    DATA_REPOSITORY

    // Paging
    implementation(SupportLibs.paging)
}