package onboarding

fun solution2(cryptogram: String): String {
    return removeReduplication(cryptogram)
}

private fun removeReduplication(string: String): String {
    var index = 0
    var string= string

    while (index < string.length) {
        var compareIndex = 0
        while (compareIndex < string.length) {
            if (string[compareIndex] == string[compareIndex+1]) {
                string = string.removeRange(IntRange(compareIndex, compareIndex+1))
                break
            } else {
                compareIndex++
            }
        }
        index++
    }
    return string
}