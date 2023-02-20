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

}