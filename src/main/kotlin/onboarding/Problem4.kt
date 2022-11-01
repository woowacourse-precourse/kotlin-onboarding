package onboarding

import java.lang.StringBuilder

fun solution4(word: String): String {
    val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lower = "abcdefghijklmnopqrstuvwxyz"
    var code = StringBuilder() // 동적으로 문자열을 조절할 수 있는 빈 객체

    for (i in word) {
        if (i in upper) {
            val i_upper_index = upper.indexOf(i)
            code.append(upper[25-i_upper_index])
        }
        else if (i in lower) {
            val i_lower_index = lower.indexOf(i)
            code.append(lower[25-i_lower_index])
        }
        else if (i.code < 65 || i.code > 90 || i.code < 97 || i.code > 122) {
            code.append(i)
        }
    }

    return code.toString()
}
