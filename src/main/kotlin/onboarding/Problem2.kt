package onboarding

fun checkContinuousString(cryptogram: String): Boolean {
    var ch = cryptogram[0]
    for(i in 0 until cryptogram.length - 1) {
        if(ch == cryptogram[i + 1])
            return true
        else
            ch = cryptogram[i + 1]
    }
    return false
}

fun solution2(cryptogram: String): String {
    var result = cryptogram

    return result
}
