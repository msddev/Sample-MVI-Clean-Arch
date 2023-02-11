package commons

import com.android.build.api.dsl.BuildType
import com.android.build.gradle.LibraryExtension
import gradle.kotlin.dsl.accessors._c662f48c4c26c34521d1054f12b949ab.implementation
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidCoreLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.applyPlugins()
        project.androidConfig()
        project.dependenciesConfig()
    }

    private fun Project.applyPlugins() {
        plugins.apply("com.android.library")
        plugins.apply("org.jetbrains.kotlin.android")
        plugins.apply("org.jetbrains.kotlin.kapt")
    }

    private fun Project.androidConfig() = extensions.getByType(LibraryExtension::class).run {
        compileSdk = 33
        defaultConfig.apply {
            minSdk = 24
            targetSdk = 33
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions.apply {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        project.tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
                freeCompilerArgs = listOf(
                    "-Xjvm-default=all",
                    "-Xopt-in=kotlin.RequiresOptIn",
                    "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
                    "-Xopt-in=kotlinx.coroutines.FlowPreview",
                    "-Xopt-in=kotlin.Experimental"
                )
            }
        }

        buildTypes.apply {
            getByName("release") {
                proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            }
            getByName("debug") {
                proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            }
        }

        testOptions.apply {
            unitTests {
                isIncludeAndroidResources = true
            }
        }
    }

    private fun BuildType.buildConfigStringField(name: String, value: String) {
        this.buildConfigField("String", name, "\"$value\"")
    }

    private fun Project.dependenciesConfig(){
        dependencies {
            implementation("androidx.core:core-ktx:1.9.0")
        }
    }
}