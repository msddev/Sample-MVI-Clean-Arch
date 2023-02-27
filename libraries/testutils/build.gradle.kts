plugins {
    androidCommonLibrary
}

android {
    namespace = "com.example.testutils"
}

dependencies {
    api(TestLibs.junit)
    api(AndroidTestingLib.junit_ext)
    api(AndroidTestingLib.espresso_core)
    api(SupportLibs.coroutine_test)
    api(TestLibs.truth)
    api(TestLibs.robolectric)
    api(TestLibs.turbine)
    api(TestLibs.mockk)
    api(TestLibs.mockwebserver)
    api(TestLibs.hamcrest_library)
    api(TestLibs.json)
    implementation(NetworkLibs.moshi)
    implementation(NetworkLibs.retrofit)
    implementation(NetworkLibs.retrofit_moshi)
    implementation(NetworkLibs.logging_interceptor)
}