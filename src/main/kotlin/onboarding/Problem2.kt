package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {
    checkLetters(cryptogram)

    val stack = Stack<Char>()

    cryptogram.onEachIndexed { index, letter ->
        when (index == 0) {
            true -> stack.push(letter)
            false -> checkPeekSameLetter(stack, letter)
        }
    }
    return stack.joinToString("")
}

fun checkLetters(cryptogram: String) {
    require(cryptogram.length in 1..1000) { "cryptogram은 길이가 1 이상 1000 이하인 문자열이다." }
    require(cryptogram.all { letter: Char -> letter.isLowerCase() }) { "cryptogram은 알파벳 소문자로만 이루어져 있다." }
}

fun checkPeekSameLetter(stack: Stack<Char>, letter: Char) {
    if (stack.peek() == letter) {
        stack.pop()
    } else {
        stack.push(letter)
    }
}