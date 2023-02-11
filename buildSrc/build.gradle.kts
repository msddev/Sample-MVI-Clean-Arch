plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        register("AndroidCoreLibraryPlugin") {
            id = "android.core.library.plugin"
            implementationClass = "commons.AndroidCoreLibraryPlugin"
        }
    }
}

object Deps {
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:7.4.1"
    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0"
}

dependencies {
    implementation(Deps.ANDROID_GRADLE)
    implementation(Deps.KOTLIN_GRADLE)
}