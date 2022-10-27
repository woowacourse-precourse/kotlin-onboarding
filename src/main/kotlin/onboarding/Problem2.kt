package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    exception(cryptogram)
    return repeat_remove_overlap(cryptogram)
}

fun exception(cryptogram: String) {
    if(cryptogram.length < 1 || cryptogram.length > 1000) {
        throw IllegalArgumentException("cryptogram의 길이는 1이상 1000이하여야 합니다.")
    }

    if(!cryptogram.matches("^[a-z]*$".toRegex())) {
        throw IllegalArgumentException("cryptogram은 소문자로 이루어져야 합니다.")
    }
}

fun remove_overlap(cryptogram: String) : String{
    var str = cryptogram

    for(c in cryptogram) {
        var duplicate = "$c{2,}"
        str = str.replace(duplicate.toRegex(), " ")
    }

    return str.replace("\\s+".toRegex(), "")
}

fun repeat_remove_overlap(cryptogram: String) : String {
    var str = cryptogram
    var result = cryptogram

    while(true) {
        str = remove_overlap(str)
        println(str)

        if(result.length == str.length) {
            return result
        }

        if(result.length > str.length) {
            result = str
        }
    }
}