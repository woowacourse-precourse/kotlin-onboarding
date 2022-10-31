package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    return getDecryptText(cryptogram)
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

fun getEditedTextCurrentStep(duplicateCharIdxListList: MutableList<Boolean>, originalStr: String): String {
    var tmpStr = ""
    for (i in 0 until duplicateCharIdxListList.size) {
        if (!duplicateCharIdxListList[i]) tmpStr += originalStr[i]
    }
    return tmpStr
}

fun getDecryptText(cryptogram: String): String {
    var editedStr = cryptogram
    var duplicateCharIdxListList = getDuplicateCharIdxList(editedStr)

    while (duplicateCharIdxListList.contains(true)) {
        editedStr = getEditedTextCurrentStep(duplicateCharIdxListList, editedStr)
        duplicateCharIdxListList = getDuplicateCharIdxList(editedStr)
    }

    return editedStr
}