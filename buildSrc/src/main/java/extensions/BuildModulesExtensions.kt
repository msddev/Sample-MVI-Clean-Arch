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

val DependencyHandler.DATA_MODEL
    get() = implementation(project(mapOf("path" to ":data:model")))

val DependencyHandler.DATA_LOCAL
    get() = implementation(project(mapOf("path" to ":data:local")))

val DependencyHandler.DATA_REMOTE
    get() = implementation(project(mapOf("path" to ":data:remote")))

val DependencyHandler.DATA_REPOSITORY
    get() = implementation(project(mapOf("path" to ":data:repository")))

val DependencyHandler.DOMAIN
    get() = implementation(project(mapOf("path" to ":domain")))

val DependencyHandler.LIBRARY_FRAMEWORK
    get() = implementation(project(mapOf("path" to ":libraries:framework")))

val DependencyHandler.LIBRARY_SAMPLE_FRAMEWORK
    get() = implementation(project(mapOf("path" to ":libraries:sampleframework")))

val DependencyHandler.LIBRARY_TEST_UTILS
    get() = implementation(project(mapOf("path" to ":libraries:testutils")))

val DependencyHandler.COMMON_THEME
    get() = implementation(project(mapOf("path" to ":common:theme")))

val DependencyHandler.COMMON_PROVIDER
    get() = implementation(project(mapOf("path" to ":common:provider")))

val DependencyHandler.COMMON_COMPONENT
    get() = implementation(project(mapOf("path" to ":common:component")))