import extensions.*

plugins {
    androidCommonLibrary
    androidCommonHilt
}

android {
    namespace = "com.example.domain"
}

dependencies {
    FRAMEWORK
    MODEL
    LOCAL
    REMOTE
    REPOSITORY
}