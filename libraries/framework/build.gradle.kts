import extensions.implementation
import extensions.ksp

plugins {
    androidCommonFeature
}

android {
    namespace = "com.example.framework"
}

dependencies {
    implementation(SupportLibs.paging)

    implementation(NetworkLibs.moshi)
    implementation(NetworkLibs.moshi_lazy_adapter)

    implementation(NetworkLibs.retrofit)
    implementation(NetworkLibs.retrofit_moshi)

    implementation(StorageLibs.room_ktx)
}