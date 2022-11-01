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
    }

    return code.toString()
}
