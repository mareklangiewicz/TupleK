import pl.mareklangiewicz.defaults.*
import pl.mareklangiewicz.deps.*
import pl.mareklangiewicz.utils.*

plugins {
  plug(plugs.KotlinMulti) apply false
}

val enableJs = true
val enableNative = true

defaultBuildTemplateForRootProject(
  lib(
    myLibInfo(
      name = "TupleK",
      description = "Tiny tuples lib for Kotlin with cool infix syntax.",
      githubUrl = "https://github.com/mareklangiewicz/TupleK",
      version = Ver(0, 0, 22),
      // https://s01.oss.sonatype.org/content/repositories/releases/pl/mareklangiewicz/tuplek/
      // https://github.com/mareklangiewicz/TupleK/releases
    ),
    flags = LibFlags(
      withJs = enableJs,
      withLinuxX64 = enableNative,
      withCentralPublish = true,
    ),
    // The nested model said `compose = null`; presence is now a flag on the factory.
    withCompose = false,
  ),
)

// region [[Root Build Template]]

fun Project.defaultBuildTemplateForRootProject(lib: Lib? = null) {
  lib?.let {
    rootExtLib = it
    defaultGroupAndVerAndDescription(it)
  }
}

// endregion [[Root Build Template]]
