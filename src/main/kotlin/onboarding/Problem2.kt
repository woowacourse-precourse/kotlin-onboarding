package onboarding

fun solution2(cryptogram: String): String {
    return removeDuplicates(cryptogram)
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