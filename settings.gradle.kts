val projectName: String by settings
rootProject.name = projectName

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}