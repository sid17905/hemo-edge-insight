pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application" -> useVersion("8.6.1")
                "org.jetbrains.kotlin.android" -> useVersion("2.1.21")
                "org.jetbrains.kotlin.plugin.compose" -> useVersion("2.1.21")
                "com.google.devtools.ksp" -> useVersion("2.1.21-2.0.1")
                "com.google.dagger.hilt.android" -> useVersion("2.58")
                "com.google.gms.google-services" -> useVersion("4.4.2")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "HemoEdgeRoot"

// Make the repo root openable as a single Android project that points to the native app.
include(":app")
project(":app").projectDir = file("hemo-native/app")

