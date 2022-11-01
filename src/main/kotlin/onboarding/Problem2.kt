package onboarding

fun solution2(cryptogram: String): String {
    if (isAppropriateCryptogram(cryptogram) != "") {
        return isAppropriateCryptogram(cryptogram)
    }

    val cryptogramList = mutableListOf<String>()
    val consecutiveCharIndex = HashSet<Int>()

    for (i in cryptogram.indices) {
        cryptogramList.add(cryptogram[i].toString())
    }
    repeat(cryptogram.length / 2) {
        for (i in 0 until cryptogramList.size - 1) {
            if (cryptogramList[i] == cryptogramList[i + 1]) {
                consecutiveCharIndex.add(i + 1)
                consecutiveCharIndex.add(i)
            }
        }
        for (i in consecutiveCharIndex.sortedDescending()) {
            cryptogramList.removeAt(i)
        }
        consecutiveCharIndex.clear()
    }

    return if (cryptogramList.isEmpty()) "" else cryptogramList.joinToString("")
}

fun isAppropriateCryptogram(cryptogram: String) = when {
    cryptogram.length !in 1..1000 -> "cryptogram 길이가 1이상 1000 이하인지 확인해주세요."
    cryptogram.count { it !in 'a'..'z' } > 0 -> "cryptogram에 알파벳 소문자 이외것이 있는지 확인해주세요."
    else -> ""
}
