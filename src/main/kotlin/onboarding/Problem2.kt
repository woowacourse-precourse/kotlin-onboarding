package onboarding

import java.util.*

fun solution2(cryptogram: String): String {

    var str = cryptogram

    while (!isValidString(str)) {
        str = deleteDuplicate(str)
    }

    return str
}

fun isValidString(str: String): Boolean {
    for (i in 0..str.length-2) {
        if (str[i] == str[i + 1]) {
            return false
        }
    }
    return true
}

fun deleteDuplicate(str: String): String {
    val findDuplicate = "a{2,}|b{2,}|c{2,}|d{2,}|e{2,}|f{2,}|g{2,}|h{2,}|i{2,}|j{2,}|k{2,}|l{2,}|m{2,}|n{2,}|o{2,}|p{2,}|q{2,}|r{2,}|s{2,}|t{2,}|u{2,}|v{2,}|w{2,}|x{2,}|y{2,}|z{2,}".toRegex()
    var answer = ""
    answer = str.replace(findDuplicate, "")
    return answer
}