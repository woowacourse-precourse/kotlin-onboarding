package onboarding

fun removeConsecutiveDuplicateCharacters(cryptogram: String): String {
    var decodedString = ""
    var isConsecutive = false

    for (i in 0 until cryptogram.length) {
        if (i == cryptogram.length - 1) {
            // 현재 검사하고 있는 문자가 마지막 문자이고 그 전의 문자와 연속적으로 반복되지 않고 있다면 해독한 문자열에 추가한다.
            if (!isConsecutive) {
                decodedString += cryptogram[i]
            }
        } else {
            if (cryptogram[i] == cryptogram[i + 1]) {
                isConsecutive = true
            } else {
                // 현재 검사하고 있는 문자가 다음 문자와 다르고 그 전의 문자와 연속적으로 반복되지 않고 있다면 해독한 문자열에 추가한다.
                if (!isConsecutive) {
                    decodedString += cryptogram[i]
                }
                isConsecutive = false
            }
        }
    }

    if (cryptogram.length != decodedString.length) return removeConsecutiveDuplicateCharacters(decodedString)
    return decodedString
}

fun solution2(cryptogram: String): String {
    return removeConsecutiveDuplicateCharacters(cryptogram)
}
