# TupleK

> **Moved.** This code now lives in [KGround](https://github.com/mareklangiewicz/KGround)
> as the `:tuplek` module. This repository is archived and no longer built or released.
> The artifact id is unchanged -- `pl.mareklangiewicz:tuplek` still works -- but new versions
> come from KGround's release line, not the old 0.0.x one. Depending on `kground` is enough,
> since it api-exposes `tuplek`.

Tiny tuples lib for Kotlin with cool infix syntax.

Stolen from Jesse Wilson gist:

- https://gist.github.com/swankjesse/095ccdcc7a95621f499b3548fc944b6d

### Example

```kotlin
    fun tuplek() {
        println("a" to "b")
        println("a" to "b" tre "c")
        println("a" to "b" tre "c" fo "d")
        println("a" to "b" tre "c" fo "d" fi "e")
        println("a" to "b" tre "c" fo "d" fi "e" sik "f")
        println("a" to "b" tre "c" fo "d" fi "e" sik "f" seva "g")
    }
```
