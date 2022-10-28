package onboarding

import kotlin.math.abs


/**
    대문자
    65 + 90 = 155
    소문자
    97 + 122 = 219
    공백 = 32
 */
fun solution4(word: String): String {
    var result = ""

    for (i in word.indices) {
        val c = word[i]
        // 소문자
        if (c == ' ')
            result += " "
        else if (c.code >= 97) {
            result += abs(219 - word[i].code).toChar()
        }else {
            result += abs(155 - word[i].code).toChar()
        }
    }

    return result
}

fun main() {
    println(solution4("I love you"))
}

