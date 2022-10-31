package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    return ""
}

fun getDuplicateCharIdxList(str: String): MutableList<Boolean> {
    val duplicateCharIdxListList: MutableList<Boolean> = ArrayList(Collections.nCopies(str.length, false))
    for (strIdx in 0 until str.lastIndex) {
        checkDuplicateCharIdx(duplicateCharIdxListList, strIdx, str)
    }
    return duplicateCharIdxListList
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