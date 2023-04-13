#!/usr/bin/env kotlin
@file:DependsOn("io.github.typesafegithub:github-workflows-kt:0.40.1")

import io.github.typesafegithub.workflows.actions.actions.CheckoutV3
import io.github.typesafegithub.workflows.actions.actions.SetupJavaV3
import io.github.typesafegithub.workflows.actions.gradle.GradleBuildActionV2
import io.github.typesafegithub.workflows.domain.RunnerType.UbuntuLatest
import io.github.typesafegithub.workflows.domain.triggers.Push
import io.github.typesafegithub.workflows.dsl.expressions.expr
import io.github.typesafegithub.workflows.dsl.workflow
import io.github.typesafegithub.workflows.yaml.writeToFile

val myFork = expr { "${github.repository_owner} == 'langara'" }

val myEnv = listOf(
    "signing_keyId", "signing_password", "signing_key",
    "ossrhUsername", "ossrhPassword", "sonatypeStagingProfileId"
)
    .map { "MYKOTLIBS_$it" }
    .associateWith { expr("secrets.$it") } as LinkedHashMap<String, String>

workflow(
    name = "Release",
    on = listOf(Push(tags = listOf("v*.*.*"))),
    sourceFile = __FILE__.toPath(),
    env = myEnv,
) {
    job(
        id = "release",
        runsOn = UbuntuLatest,
    ) {
        uses(CheckoutV3())
        uses(
            name = "Set up JDK",
            action = SetupJavaV3(
                javaVersion = "17",
                distribution = SetupJavaV3.Distribution.Zulu,
            )
        )
        uses(
            name = "Build",
            action = GradleBuildActionV2(
                arguments = "build",
            )
        )
        uses(
            name = "Publish to Sonatype",
            action = GradleBuildActionV2(
                arguments = "publishToSonatype closeAndReleaseSonatypeStagingRepository",
            )
        )
//        uses(
//            name = "Wait until library present in Maven Central",
//            action = GradleBuildActionV2(
//                arguments = "waitUntilLibraryPresentInMavenCentral",
//            )
//        )
    }
}.writeToFile()