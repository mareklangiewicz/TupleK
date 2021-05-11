package pl.mareklangiewicz.tuplek

infix fun <A, B, C> Pair<A, B>.tre(c: C) = Triple(first, second, c)
infix fun <A, B, C, D> Triple<A, B, C>.fo(d: D) = Quad(first, second, third, d)
infix fun <A, B, C, D, E> Quad<A, B, C, D>.fi(e: E) = Jackson(a, b, c, d, e)
infix fun <A, B, C, D, E, F> Jackson<A, B, C, D, E>.sik(f: F) = Rainbow(a, b, c, d, e, f)
infix fun <A, B, C, D, E, F, G> Rainbow<A, B, C, D, E, F>.seva(g: G) = Lucky(a, b, c, d, e, f, g)

data class Quad<out A, out B, out C, out D>(
    val a: A,
    val b: B,
    val c: C,
    val d: D
)

data class Jackson<out A, out B, out C, out D, out E>(
    val a: A,
    val b: B,
    val c: C,
    val d: D,
    val e: E
)

data class Rainbow<out A, out B, out C, out D, out E, out F>(
    val a: A,
    val b: B,
    val c: C,
    val d: D,
    val e: E,
    val f: F
)

data class Lucky<out A, out B, out C, out D, out E, out F, out G>(
    val a: A,
    val b: B,
    val c: C,
    val d: D,
    val e: E,
    val f: F,
    val g: G
)