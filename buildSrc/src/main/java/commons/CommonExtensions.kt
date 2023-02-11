package commons

import com.android.build.api.dsl.CommonExtension

/**
 * Adds the base Compose configurations on Gradle.
 */
fun CommonExtension<*, *, *, *>.addComposeConfig() {
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

/**
 * Adds the base default app configurations on Gradle.
 */
fun CommonExtension<*, *, *, *>.addDefaultConfig() {
    defaultConfig {
        compileSdk = 33
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}