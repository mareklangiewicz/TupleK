plugins {
    kotlin("multiplatform") version Vers.kotlin
    id("maven-publish")
}

group = "pl.mareklangiewicz.tuplek"
version = "0.0.04"

repositories {
    mavenCentral()
    maven(Repos.jitpack)
}

kotlin {
    jvm()
//    js {
//        browser()
//    }
//    linuxX64()

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Deps.junit5engine)
                implementation(Deps.uspekx)
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
