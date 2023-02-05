buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.1")
    }
}

plugins {
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}