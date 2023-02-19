package commons

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Configs.CompileSdk

    defaultConfig {
        minSdk = Configs.MinSdk
        testInstrumentationRunner = Configs.AndroidJunitRunner
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = Configs.FreeCompilerArgs
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(SupportLibs.core_ktx)
    implementation(SupportLibs.app_compat)
    implementation(SupportLibs.material)
    implementation(SupportLibs.lifecycle_runtime)
    implementation(SupportLibs.activity_ktx)
    implementation(SupportLibs.coroutine_core)
    implementation(SupportLibs.coroutine_android)

    // Common
    implementation(CommonLibs.timber)

    testImplementation(TestLibs.junit)
    androidTestImplementation(AndroidTestingLib.junit_ext)
    androidTestImplementation(AndroidTestingLib.espresso_core)
}