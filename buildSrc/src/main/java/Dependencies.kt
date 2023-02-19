const val kotlinAndroid: String = "android"
const val kotlinKapt: String = "kapt"

object Versions {
    const val compose = "1.3.3"
    const val compose_compiler = "1.4.2"
    const val accompanist = "0.28.0"
    const val compose_destinations = "1.8.33-beta"
}

object SupportLibs {
    const val core_ktx = "androidx.core:core-ktx:1.9.0"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val app_compat = "androidx.appcompat:appcompat:1.6.0"
    const val material = "com.google.android.material:material:1.8.0"
    const val splash_screen = "androidx.core:core-splashscreen:1.0.0"
    const val activity_ktx = "androidx.activity:activity-ktx:1.6.1"
    const val coroutine_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    const val coroutine_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    const val paging = "androidx.paging:paging-runtime-ktx:3.1.1"
}

object ComposeLibs {
    const val activity = "androidx.activity:activity-compose:1.6.1"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val material_3 = "androidx.compose.material3:material3:1.1.0-alpha05"
    const val material = "androidx.compose.material:material:1.3.1"
    const val paging = "androidx.paging:paging-compose:1.0.0-alpha18"
}

object AccompanistLibs {
    const val swipe_refresh =
        "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"
    const val system_ui_controller =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
    const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val placeholder_material =
        "com.google.accompanist:accompanist-placeholder-material:${Versions.accompanist}"
    const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
    const val navigation_material =
        "com.google.accompanist:accompanist-navigation-material:${Versions.accompanist}"
    const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
    const val pager_indicators =
        "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanist}"
    const val webview = "com.google.accompanist:accompanist-webview:${Versions.accompanist}"
}

object NavigationLibs {
    const val navigation = "androidx.navigation:navigation-compose:2.5.3"
    const val destination_core =
        "io.github.raamcosta.compose-destinations:core:${Versions.compose_destinations}"
    const val destination_ksp =
        "io.github.raamcosta.compose-destinations:ksp:${Versions.compose_destinations}"
    const val destination_animation =
        "io.github.raamcosta.compose-destinations:animations-core:${Versions.compose_destinations}"
}

object DaggerHiltLibs {
    const val android = "com.google.dagger:hilt-android:2.45"
    const val compiler = "com.google.dagger:hilt-android-compiler:2.45"
    const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
}

object TestLibs {
    const val junit = "junit:junit:4.13.2"
}

object AndroidTestingLib {
    const val junit_ext = "androidx.test.ext:junit:1.1.5"
    const val espresso_core = "androidx.test.espresso:espresso-core:3.5.1"
}

object ComposeTestingLib {
    const val ui_test_junit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val ui_test_manifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
}

object CommonLibs {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
}

object StorageLibs {
    const val room_ktx = "androidx.room:room-ktx:2.5.0"
    const val room_compiler = "androidx.room:room-compiler:2.5.0"
    const val datastore_pref = "androidx.datastore:datastore-preferences:1.0.0"
    const val datastore = "androidx.datastore:datastore:1.0.0"
    const val security_pref = "androidx.security:security-crypto-ktx:1.1.0-alpha04"
}