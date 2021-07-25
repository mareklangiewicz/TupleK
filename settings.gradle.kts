@file:Suppress("UnstableApiUsage")
@file:OptIn(okio.ExperimentalFileSystem::class)

import okio.Path.Companion.toPath

//gradle.logSomeEventsToFile("my.gradle.log".toPath())

pluginManagement {
    includeBuild("../deps.kt")
}

plugins {
    id("pl.mareklangiewicz.deps.settings")
}

include(":tuplek")
