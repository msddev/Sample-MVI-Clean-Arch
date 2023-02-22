import extensions.implementation

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
    implementation(NetworkLibs.logging_interceptor)
    debugImplementation(NetworkLibs.chucker_debug)
    releaseImplementation(NetworkLibs.chucker_release)

    implementation(StorageLibs.room_ktx)
    implementation(StorageLibs.datastore_pref)
    implementation(StorageLibs.datastore)
    implementation(StorageLibs.security_pref)
}