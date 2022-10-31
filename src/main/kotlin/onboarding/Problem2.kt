package onboarding

fun solution2(cryptogram: String): String {
    var word = cryptogram

    do {
        var loopCheck = false
        for (left in 0 until word.length-1){
            var right = left + 1
            while (word[left] == word.getOrNull(right))
                right++

            if (right != left+1){
                word = word.removeRange(left, right)
                loopCheck = true
                break
            }
        }
    } while (loopCheck)

    return word
}
