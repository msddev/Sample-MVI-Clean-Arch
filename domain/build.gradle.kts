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
    LIBRARY_TEST_UTILS
    DATA_MODEL
    DATA_LOCAL
    DATA_REMOTE
    DATA_REPOSITORY

    // Paging
    implementation(SupportLibs.paging)
}