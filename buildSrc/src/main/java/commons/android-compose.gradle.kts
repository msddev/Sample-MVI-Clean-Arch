package commons

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

dependencies {
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

    // Test
    androidTestImplementation(ComposeTestingLib.ui_test_junit)
    debugImplementation(ComposeTestingLib.ui_test_manifest)
}