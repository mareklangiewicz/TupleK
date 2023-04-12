#!/usr/bin/env kotlin
@file:DependsOn("io.github.typesafegithub:github-workflows-kt:0.40.1")

import io.github.typesafegithub.workflows.actions.actions.CheckoutV3
import io.github.typesafegithub.workflows.actions.actions.SetupJavaV3
import io.github.typesafegithub.workflows.actions.gradle.GradleBuildActionV2
import io.github.typesafegithub.workflows.domain.RunnerType.UbuntuLatest
import io.github.typesafegithub.workflows.domain.triggers.PullRequest
import io.github.typesafegithub.workflows.domain.triggers.Push
import io.github.typesafegithub.workflows.dsl.JobBuilder
import io.github.typesafegithub.workflows.dsl.expressions.expr
import io.github.typesafegithub.workflows.dsl.workflow
import io.github.typesafegithub.workflows.yaml.writeToFile

// Warning: Might need to clean cache after changing file
//   ~/.cache$ rm -rf main.kts.compiled.cache/

fun JobBuilder<*>.setupJava() =
    uses(
        name = "Set up JDK",
        action = SetupJavaV3(
            javaVersion = "17",
            distribution = SetupJavaV3.Distribution.Zulu,
        )
    )

val notMyFork = expr { "${github.repository_owner} != 'langara'" }

workflow(
    name = "Build",
    on = listOf(
        Push(branches = listOf("master")),
        PullRequest(),
    ),
    sourceFile = __FILE__.toPath(),
) {
    listOf(UbuntuLatest).forEach { runnerType ->
        job(
            id = "build-for-${runnerType::class.simpleName}",
            runsOn = runnerType,
        ) {
            uses(CheckoutV3())
            setupJava()
            uses(
                name = "Build",
                action = GradleBuildActionV2(
                    arguments = "build",
                )
            )
        }
    }
}.writeToFile()