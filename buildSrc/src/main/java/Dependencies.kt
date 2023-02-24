const val kotlinAndroid: String = "android"
const val kotlinKapt: String = "kapt"

object Versions {
    const val kotlinx_coroutines = "1.6.4"
    const val hilt_android = "2.45"
    const val compose = "1.3.3"
    const val compose_compiler = "1.4.2"
    const val accompanist = "0.28.0"
    const val compose_destinations = "1.8.33-beta"
    const val moshi_kotlin = "1.14.0"
    const val retrofit = "2.9.0"
    const val okhttp = "5.0.0-alpha.11"
    const val chucker = "3.5.2"
    const val room = "2.5.0"
    const val datastore = "1.0.0"
    const val material_icons = "1.3.1"
}

object SupportLibs {
    const val core_ktx = "androidx.core:core-ktx:1.9.0"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val app_compat = "androidx.appcompat:appcompat:1.6.0"
    const val material = "com.google.android.material:material:1.8.0"
    const val splash_screen = "androidx.core:core-splashscreen:1.0.0"
    const val activity_ktx = "androidx.activity:activity-ktx:1.6.1"
    const val coroutine_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines}"
    const val coroutine_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines}"
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
    const val coil = "io.coil-kt:coil-compose:2.2.2"
    const val material_icon_core =
        "androidx.compose.material:material-icons-core:${Versions.material_icons}"
    const val material_icon_extended =
        "androidx.compose.material:material-icons-extended:${Versions.material_icons}"
    const val lottie = "com.airbnb.android:lottie-compose:6.0.0"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout-compose:1.0.0"
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
    const val android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"
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
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val datastore_pref = "androidx.datastore:datastore-preferences:${Versions.datastore}"
    const val datastore = "androidx.datastore:datastore:${Versions.datastore}"
    const val security_pref = "androidx.security:security-crypto-ktx:1.1.0-alpha04"
}

object NetworkLibs {
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi_kotlin}"
    const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi_kotlin}"
    const val moshi_lazy_adapter = "com.serjltt.moshi:moshi-lazy-adapters:2.2"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val chucker_debug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chucker_release = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    const val kotlinx_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
    const val kotlinx_serialization_retrofit =
        "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
}