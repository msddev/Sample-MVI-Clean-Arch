import extensions.*

plugins {
    androidCommonLibrary
    androidCommonHilt
    ksp
}

android {
    namespace = "com.example.local"
}

dependencies {
    LIBRARY_FRAMEWORK
    LIBRARY_TEST_UTILS
    DATA_MODEL

    implementation(StorageLibs.room_ktx)
    ksp(StorageLibs.room_compiler)
}