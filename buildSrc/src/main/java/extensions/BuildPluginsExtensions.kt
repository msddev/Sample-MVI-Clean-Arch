import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id("com.android.application")

val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = id("com.android.library")

val PluginDependenciesSpec.androidCommonFeature: PluginDependencySpec
    get() = id("commons.android-feature")

val PluginDependenciesSpec.androidCommonLibrary: PluginDependencySpec
    get() = id("commons.android-library")

val PluginDependenciesSpec.androidCommonCompose: PluginDependencySpec
    get() = id("commons.android-compose")

val PluginDependenciesSpec.androidCommonHilt: PluginDependencySpec
    get() = id("commons.dagger-hilt")

val PluginDependenciesSpec.kotlin: PluginDependencySpec
    get() = id("kotlin")

val PluginDependenciesSpec.daggerHilt: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")

val PluginDependenciesSpec.ksp: PluginDependencySpec
    get() = id("com.google.devtools.ksp")

val PluginDependenciesSpec.kotlinLibrary: PluginDependencySpec
    get() = id("kotlin-library")

val PluginDependenciesSpec.safeArgs: PluginDependencySpec
    get() = id("androidx.navigation.safeargs.kotlin")

val PluginDependenciesSpec.parcelize: PluginDependencySpec
    get() = id("kotlin-parcelize")