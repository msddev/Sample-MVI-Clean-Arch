package commons

import CommonLibs
import Configs
import SupportLibs
import com.android.build.api.dsl.BuildType

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

android {
    compileSdk = Configs.CompileSdk

    defaultConfig {
        minSdk = Configs.MinSdk
        testInstrumentationRunner = Configs.AndroidJunitRunner
    }

    buildTypes {
        release {
            buildConfigStringField("BASE_URL", Configs.Release.BaseUrl)
            buildConfigStringField("DB_NAME", Configs.Release.DbName)
        }

        debug {
            buildConfigStringField("BASE_URL", Configs.Debug.BaseUrl)
            buildConfigStringField("DB_NAME", Configs.Debug.DbName)
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
        unitTests.all {
            it.systemProperty("robolectric.enabledSdks'", "24")
            it.systemProperty("robolectric.dependency.repo.id'", "mavenCentral")
            it.systemProperty("robolectric.dependency.repo.url", "https://repo1.maven.org/maven2")
        }
    }
}

fun BuildType.buildConfigStringField(name: String, value: String) {
    this.buildConfigField("String", name, "\"$value\"")
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
}