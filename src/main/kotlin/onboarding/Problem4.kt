package onboarding

fun solution4(word: String): String = word.map {
    when(it) {
        in 'a'..'z' -> ('z'.code + 'a'.code - it.code).toChar().toString()
        in 'A'..'Z' -> ('Z'.code + 'A'.code - it.code).toChar().toString()
        else -> it.toString()
    }
}.reduce { acc, s -> acc + s }
