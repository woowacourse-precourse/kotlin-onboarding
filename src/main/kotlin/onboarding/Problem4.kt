package onboarding

import java.lang.StringBuilder

fun solution4(word: String): String {
    var str = StringBuilder(word)
    // 65~90 26개가 A~Z임.
    // 97~122 26개가 a~z임.
    for (i in str.toString().indices) {
        var code = word[i].code
        if (code in 65..90) { // 대문자이면 소문자로 변환.
            if (str[i].code >= 78) {
                val ch: Char = (65 + 90 - str[i].code).toChar()
                str.replace(i, i + 1, ch.toString())
            } else {
                val ch: Char = (90 - str[i].code + 65).toChar()
                str.replace(i, i + 1, ch.toString())
            }
        }
        else if(code in 97..122){
            if (str[i].code >= 109) {
                val ch: Char = (97 + 122 - str[i].code).toChar()
                str.replace(i, i + 1, ch.toString())
            } else {
                val ch: Char = (122 - str[i].code + 97).toChar()
                str.replace(i, i + 1, ch.toString())
            }
        }
    }

    return str.toString()
}
