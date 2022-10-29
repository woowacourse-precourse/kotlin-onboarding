package onboarding

fun solution2(cryptogram: String): String {
    var result: String = cryptogram

    while(isCryptogram(result)){
        result = getSolve(result)
    }

    return result
}

fun isCryptogram(str: String): Boolean {
    for (i in 1..str.length-1) {
        if (str[i - 1] == str[i]) {
            return true
        }
    }

    return false
}

fun getSolve(_str: String): String {
    var str: String = _str

    for (i in 1..str.length-1) {
        if (str[i - 1] == str[i]) {
            str = str.replaceRange(i-1..i, "  ")
        }
    }

    return str.replace("  ", "")
}