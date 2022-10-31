package onboarding

fun solution2(cryptogram: String): String {
    var result = cryptogram
    while (true){
        val removedStr = removeRepeat(result) // remove sequence string
        if (removedStr == result) break // there is no way to remove
        result = removedStr
    }
    return result
}

fun removeRepeat(cryp: String): String{
    var removedStr = ""
    var previousStr = ' '
    for (char in cryp) {
        if (previousStr != char){  // the case string is not sequence
            previousStr = char
            removedStr += char
        }
        else removedStr = removedStr.dropLast(1) // slice string until last word-1
    }
    return removedStr
}