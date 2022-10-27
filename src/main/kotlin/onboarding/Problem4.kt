package onboarding

import java.lang.StringBuilder

val lowerCaseMap = HashMap<Char, Char>()
val upperCaseMap = HashMap<Char, Char>()
fun solution4(word: String): String {
    initMap()
    val sb = StringBuilder()
    word.forEach {
        sb.append(it.transform())
    }
    return sb.toString()
}

fun initMap() {
    for (i in 65..90) {
        upperCaseMap[i.toChar()] = (155 - i).toChar()
    }
    for (i in 97..122) {
        lowerCaseMap[i.toChar()] = (219 - i).toChar()
    }
}

fun Char.transform(): Char {
    return if (this.isLowerCase()) {
        lowerCaseMap[this] ?: this
    } else if (this.isUpperCase()) {
        upperCaseMap[this] ?: this
    } else {
        this
    }
}