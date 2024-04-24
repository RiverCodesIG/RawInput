val projectName: String by settings
rootProject.name = projectName

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://repo.legacyfabric.net/repository/legacyfabric/")
    }
}