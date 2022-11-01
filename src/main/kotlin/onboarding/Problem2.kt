package onboarding

fun solution2(cryptogram: String): String {

    var result = cryptogram
    var index = 0

    while (index < result.length - 1) {
        if (result[index] == result[index + 1]) {
            result = result.removeRange(index, index + 2)
            index -= 2
        }
        index++
    }

    return result
}
