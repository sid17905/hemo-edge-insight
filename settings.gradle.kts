pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
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

