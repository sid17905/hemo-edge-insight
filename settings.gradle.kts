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
                "org.jetbrains.kotlin.android" -> useVersion("1.9.24")
                "com.google.devtools.ksp" -> useVersion("1.9.24-1.0.20")
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

