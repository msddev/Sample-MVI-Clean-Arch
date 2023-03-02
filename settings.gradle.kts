@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
    }
}
rootProject.name = "Rick-Morty"

include(
    ":app",
    ":features:home",
    ":features:settings",
    ":features:characters",
    ":features:welcome",
    ":features:splash",
    ":domain",
    ":data:local",
    ":data:remote",
    ":data:model",
    ":data:repository",
    ":common:theme",
    ":common:provider",
    ":common:component",
    ":libraries:framework",
    ":libraries:sampleframework",
    ":libraries:testutils"
)
