package onboarding

fun solution2(cryptogram: String): String {
    return getResult(cryptogram)
}

fun removeDuplication(originString: String): String {
    var resultString: String = ""

    resultString.plus(originString[0]).also { resultString = it }

    for (i in 1..originString.length - 2) {
        if ((originString[i - 1] != originString[i]) && (originString[i] != originString[i + 1])) {
            resultString.plus(originString[i]).also { resultString = it }
        }
    }

    resultString.plus(originString[originString.length - 1]).also { resultString = it }

    return resultString
}

fun getResult(resultString: String): String {
    var emptyString = ""
    var result: String = resultString

    while (emptyString != result) {
        emptyString = result
        result = removeDuplication(result)
    }

    if ((result.length == 2) && (result[0] == result[result.length - 1])) {
        result = ""
    }

    return result
}
