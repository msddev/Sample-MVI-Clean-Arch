import extensions.*

plugins {
    androidCommonLibrary
    androidCommonHilt
}

android {
    namespace = "com.example.repository"
}

dependencies {
    FRAMEWORK
    MODEL
    LOCAL
    REMOTE

    implementation(StorageLibs.datastore_pref)
}