import extensions.*

plugins {
    androidCommonLibrary
    androidCommonHilt
}

android {
    namespace = "com.example.repository"
}

dependencies {
    LIBRARY_FRAMEWORK
    DATA_MODEL
    DATA_LOCAL
    DATA_REMOTE

    implementation(StorageLibs.datastore_pref)
}