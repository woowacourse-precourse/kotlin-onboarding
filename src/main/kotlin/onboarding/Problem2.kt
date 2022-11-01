package onboarding

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}

private fun checkRepetition(secretCode: String) {
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
}