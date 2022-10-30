package onboarding

fun findDuplicate(word: String, startIndex: Int): Int {
    var nextIndex = startIndex + 1
    var result = -1

    while (nextIndex < word.length && word[startIndex] == word[nextIndex]){
        result = nextIndex++
    }
    return result
}

fun deleteDuplicate(word: String, start: Int, end: Int): String {
    return word.substring(0, start) + word.substring(end + 1, word.length)
}

fun solution2(cryptogram: String): String {
    var currentIndex = 0
    var word = cryptogram
    var endIndex: Int

    while (currentIndex < word.length) {
        endIndex = findDuplicate(word, currentIndex)
        if (endIndex == -1) {
            currentIndex++
        } else {
            word = deleteDuplicate(word, currentIndex, endIndex)
            currentIndex = 0
        }
    }
    return word
}