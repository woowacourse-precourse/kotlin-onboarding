package onboarding

fun main() {
    println(solution4("I love you"))
}

fun solution4(word: String): String {
    var result = ""
    word.forEach {
        result += when (val asciiNum = it.code) {
            in 65..90 -> (155 - asciiNum).toChar()
            in 97..122 -> (219 - asciiNum).toChar()
            else -> it
        }
    }
    return result
}
