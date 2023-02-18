package extensions

import org.gradle.api.artifacts.dsl.DependencyHandler

// Modules
val DependencyHandler.FEATURE_WELCOME
    get() = implementation(project(mapOf("path" to ":features:welcome")))

val DependencyHandler.FEATURE_SETTINGS
    get() = implementation(project(mapOf("path" to ":features:setting")))

val DependencyHandler.FEATURE_CHARACTERS
    get() = implementation(project(mapOf("path" to ":features:characters")))

val DependencyHandler.FEATURE_HOME
    get() = implementation(project(mapOf("path" to ":features:home")))

val DependencyHandler.FEATURE_SPLASH
    get() = implementation(project(mapOf("path" to ":features:splash")))

val DependencyHandler.MODEL
    get() = implementation(project(mapOf("path" to ":data:model")))

val DependencyHandler.LOCAL
    get() = implementation(project(mapOf("path" to ":data:local")))

val DependencyHandler.REMOTE
    get() = implementation(project(mapOf("path" to ":data:remote")))

val DependencyHandler.REPOSITORY
    get() = implementation(project(mapOf("path" to ":data:repository")))

val DependencyHandler.DOMAIN
    get() = implementation(project(mapOf("path" to ":domain")))

val DependencyHandler.FRAMEWORK
    get() = implementation(project(mapOf("path" to ":libraries:framework")))

val DependencyHandler.SAMPLE_FRAMEWORK
    get() = implementation(project(mapOf("path" to ":libraries:sampleframework")))

val DependencyHandler.THEME
    get() = implementation(project(mapOf("path" to ":common:theme")))

val DependencyHandler.PROVIDER
    get() = implementation(project(mapOf("path" to ":common:provider")))