plugins {
    kotlin("jvm") version ("2.0.0-RC1")
    id("net.weavemc.gradle") version ("1.0.0-PRE2")
}

val projectVersion: String by project
val projectGroup:   String by project

group = projectGroup
version = projectVersion

weave {
    configure {
        name = "Raw Input"
        modId = "RawInput"
        hooks = listOf(
            "me.river.rawinput.hooks.MinecraftHook",
            "me.river.rawinput.hooks.LunarPollingHook"
        )
        mcpMappings()
    }
    version("1.8.9")
}

repositories {
    mavenCentral()
    maven("https://repo.weavemc.dev/releases")
    maven("https://repo.spongepowered.org/maven")
}

dependencies {
    implementation("net.weavemc.api:common:1.0.0-PRE2")
    implementation("net.weavemc:internals:1.0.0-PRE2")
    compileOnly("org.spongepowered:mixin:0.8.5")
}

kotlin {
    jvmToolchain(8)
}