@file:Suppress("UnstableApiUsage")

import extensions.*

plugins {
    androidApplication
    kotlin(kotlinAndroid)
    kotlin(kotlinKapt)
    daggerHilt
    ksp
}

android {
    namespace = Configs.Id
    compileSdk = Configs.CompileSdk

    defaultConfig {
        applicationId = Configs.Id
        minSdk = Configs.MinSdk
        targetSdk = Configs.TargetSdk
        versionCode = Configs.VersionCode
        versionName = Configs.VersionName

        testInstrumentationRunner = Configs.AndroidJunitRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    // Modules
    LIBRARY_FRAMEWORK
    LIBRARY_SAMPLE_FRAMEWORK
    COMMON_THEME
    COMMON_PROVIDER

    FEATURE_SPLASH
    FEATURE_WELCOME
    FEATURE_HOME
    FEATURE_CHARACTERS
    FEATURE_SETTINGS

    // Support
    implementation(SupportLibs.core_ktx)
    implementation(SupportLibs.lifecycle_runtime)

    // Compose
    implementation(ComposeLibs.activity)
    implementation(ComposeLibs.ui)
    implementation(ComposeLibs.ui_tooling_preview)
    implementation(ComposeLibs.material)
    debugImplementation(ComposeLibs.ui_tooling)

    // Accompanist
    implementation(AccompanistLibs.swipe_refresh)
    implementation(AccompanistLibs.system_ui_controller)
    implementation(AccompanistLibs.insets)
    implementation(AccompanistLibs.placeholder_material)
    implementation(AccompanistLibs.navigation_material)
    implementation(AccompanistLibs.permissions)
    implementation(AccompanistLibs.pager)
    implementation(AccompanistLibs.pager_indicators)
    implementation(AccompanistLibs.webview)

    // Navigation
    implementation(NavigationLibs.navigation)
    implementation(NavigationLibs.destination_core)
    ksp(NavigationLibs.destination_ksp)
    implementation(NavigationLibs.destination_animation)

    // Dagger Hilt
    implementation(DaggerHiltLibs.android)
    kapt(DaggerHiltLibs.compiler)
    implementation(DaggerHiltLibs.compose)

    // Navigation
    implementation(NavigationLibs.navigation)
    implementation(NavigationLibs.destination_core)
    ksp(NavigationLibs.destination_ksp)
    implementation(NavigationLibs.destination_animation)

    // Test
    testImplementation(TestLibs.junit)
    androidTestImplementation(AndroidTestingLib.junit_ext)
    androidTestImplementation(AndroidTestingLib.espresso_core)
    androidTestImplementation(ComposeTestingLib.ui_test_junit)
    debugImplementation(ComposeTestingLib.ui_test_manifest)
}