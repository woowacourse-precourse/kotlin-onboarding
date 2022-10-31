package onboarding

fun solution2(cryptogram: String): String {
    return ""
}

fun checkDuplicateCharIdx(
    originalList: MutableList<Boolean>,
    currentIndex: Int,
    cryptogram: String
) {
    if (cryptogram[currentIndex] == cryptogram[currentIndex + 1]) {
        originalList[currentIndex] = true
        originalList[currentIndex + 1] = true
    }
}