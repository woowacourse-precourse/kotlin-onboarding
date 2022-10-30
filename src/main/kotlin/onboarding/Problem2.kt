package onboarding

fun solution2(cryptogram: String): String {
    var result = cryptogram
    while (true){
        val removedStr = removeRepeat(result)
        if (removedStr == result) break
        result = removedStr
    }
    return result
}

fun removeRepeat(cryp: String): String{
    var removedStr = ""
    var previousStr = ' '
    for (char in cryp) {
        if (previousStr != char){
            previousStr = char
            removedStr += char
        }
        else removedStr = removedStr.dropLast(1)
    }
    return removedStr
}