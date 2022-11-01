package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}

private fun checkRepetition(secretCode: String): RepetitionResult {
    val stack = mutableListOf<Char>()
    var previousChar: Char = ' '
    var isFinished: Boolean = true

    for (currentChar in secretCode) {
        if (previousChar != currentChar) {
            stack.add(currentChar)
            previousChar = currentChar
            continue
        }
        if (previousChar == stack.lastOrNull()) stack.removeLast()
        isFinished = false
    }

    return RepetitionResult(stack.joinToString(""), isFinished)
}

data class RepetitionResult(
    val secretCode: String,
    val isFinished: Boolean = false
)