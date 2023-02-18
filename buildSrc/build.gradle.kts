plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}
object Deps {
    const val ANDROID_GRADLE = "com.android.tools.build:gradle:7.4.1"
    const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:2.45"
}

dependencies {
    implementation(Deps.ANDROID_GRADLE)
    implementation(Deps.KOTLIN_GRADLE)
    implementation(Deps.HILT)
}