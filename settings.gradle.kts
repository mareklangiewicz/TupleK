@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("../deps.kt")
}

plugins {
    id("pl.mareklangiewicz.deps.settings")
}

include(":tuplek")
