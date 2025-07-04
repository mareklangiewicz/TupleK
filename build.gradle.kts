import pl.mareklangiewicz.defaults.*
import pl.mareklangiewicz.deps.*
import pl.mareklangiewicz.utils.*

plugins {
  plug(plugs.KotlinMulti) apply false
}

val enableJs = true
val enableNative = true

defaultBuildTemplateForRootProject(
  myLibDetails(
    name = "TupleK",
    description = "Tiny tuples lib for Kotlin with cool infix syntax.",
    githubUrl = "https://github.com/mareklangiewicz/TupleK",
    version = Ver(0, 0, 21),
    // https://s01.oss.sonatype.org/content/repositories/releases/pl/mareklangiewicz/tuplek/
    // https://github.com/mareklangiewicz/TupleK/releases
    settings = LibSettings(
      withJs = enableJs,
      withNativeLinux64 = enableNative,
      compose = null,
      withSonatypeOssPublishing = true,
    ),
  ),
)

// region [[Root Build Template]]

fun Project.defaultBuildTemplateForRootProject(details: LibDetails? = null) {
  details?.let {
    rootExtLibDetails = it
    defaultGroupAndVerAndDescription(it)
  }
}

// endregion [[Root Build Template]]
