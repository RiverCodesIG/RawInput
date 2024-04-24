plugins {
    kotlin("jvm") version ("2.0.0-RC1")
    id("fabric-loom") version ("1.5-SNAPSHOT")
    id("legacy-looming") version ("1.5-SNAPSHOT")
}

val projectVersion: String by project
val projectGroup:   String by project

group = projectGroup
version = projectVersion

dependencies {
    minecraft("com.mojang:minecraft:1.8.9")
    mappings(legacy.yarn("1.8.9", "535"))

    modImplementation("net.fabricmc:fabric-loader:0.15.6")
    modImplementation("net.legacyfabric.legacy-fabric-api:legacy-fabric-api:1.9.1+1.8.9")
    modImplementation("net.fabricmc:fabric-language-kotlin:1.10.17+kotlin.1.9.22")
}

kotlin {
    jvmToolchain(8)
}