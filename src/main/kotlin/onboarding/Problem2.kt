package onboarding

fun solution2(cryptogram: String): String {
    var result:String = cryptogram

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