package onboarding

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


fun checkDuplicate(word: String, start: Int): Int {
    var nextIndex = start + 1
    var result = -1

    while (nextIndex < word.length && word[start] == word[nextIndex]){
        result = nextIndex++
    }

    return result
}

fun deleteDuplicate(word: String, start: Int, end: Int): String {
    return word.substring(0, start) + word.substring(end + 1, word.length)
}

fun solution2(cryptogram: String): String {
    var index = 0
    var word = cryptogram
    var endIndex: Int

    while (index < word.length) {
        endIndex = checkDuplicate(word, index)
        if (endIndex == -1) {
            index++
        } else {
            word = deleteDuplicate(word, index, endIndex)
            index = 0
        }
    }

    return word
}