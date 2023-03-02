import extensions.*

plugins {
    androidCommonLibrary
    ksp
}

android {
    namespace = "com.example.model"
}

dependencies {
    LIBRARY_FRAMEWORK
    LIBRARY_TEST_UTILS

    implementation(NetworkLibs.moshi)
    ksp(NetworkLibs.moshi_codegen)
    implementation(NetworkLibs.moshi_lazy_adapter)

    implementation(StorageLibs.room_ktx)
    ksp(StorageLibs.room_compiler)
}