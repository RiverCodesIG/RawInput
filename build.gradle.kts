plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.weave-mc.weave-gradle") version "master-SNAPSHOT"
}

val projectVersion: String by project
val projectGroup:   String by project

group = projectGroup
version = projectVersion

minecraft.version("1.8.9")

repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.weave-mc:weave-loader:legacy-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}