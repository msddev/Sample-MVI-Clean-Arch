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
    DATA_MODEL

    implementation(StorageLibs.room_ktx)
    ksp(StorageLibs.room_compiler)
}