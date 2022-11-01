package onboarding

fun solution2(cryptogram: String): String {
    return decode(cryptogram)
}

fun decode(str: String): String {
    var encodedStr = str
    var decodedStr = str

    do {
        encodedStr = decodedStr
        decodedStr = removeDuplicates(decodedStr)
    } while(encodedStr.length != decodedStr.length)

    return decodedStr
}

fun removeDuplicates(str: String): String {
    var decodedString = str
    var i = 1
    while(i < decodedString.length) {
        if(decodedString[i-1] == decodedString[i]) {
            decodedString = decodedString.replaceRange(i-1..i, "")
        } else {
            i++
        }
    }

    return decodedString
}