@file:Suppress("UnstableApiUsage")

import okio.Path.Companion.toOkioPath
import pl.mareklangiewicz.deps.*

//gradle.logSomeEventsToFile(rootProject.projectDir.toOkioPath() / "my.gradle.log")

pluginManagement {
//    includeBuild("../DepsKt")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("pl.mareklangiewicz.deps.settings") version "0.2.69" // https://plugins.gradle.org/search?term=mareklangiewicz
}

include(":tuplek")
