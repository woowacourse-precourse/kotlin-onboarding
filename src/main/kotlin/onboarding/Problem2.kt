package onboarding

fun solution2(cryptogram: String): String {
    var reCryptogram = cryptogram
    while (duplicateCharCheck(reCryptogram)) {
        reCryptogram = updataCryptogram(reCryptogram)
    }

    return reCryptogram
}

fun updataCryptogram(reCryptogram: String): String {
    var editString = reCryptogram.toCharArray()
    for (i in 0..editString.size - 2) {
        editString = duplicateCharRemove(i, editString)
    }

    return String(editString).replace(" ", "")
}

fun duplicateCharRemove(i: Int, reCryptogram: CharArray): CharArray {
    var editString = reCryptogram
    if (editString[i] == editString[i + 1]) {
        editString[i] = ' '
        editString[i + 1] = ' '
    }
    return editString
}

fun duplicateCharCheck(cryptogram: String): Boolean {
    var duplication = 0
    for (i in 0..cryptogram.length - 2) {
        duplication += compareChar(cryptogram[i], cryptogram[i + 1])
    }
    if (duplication != 0) {
        return true
    }
    return false
}

fun compareChar(c1: Char, c2: Char): Int {
    if (c1 == c2) {
        return 1
    }
    return 0
}
