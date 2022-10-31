package onboarding

import java.util.*

private var isContinuous = false
private var previousChar = ' '

fun solution2(cryptogram: String): String {
    return cryptogram.removeDuplicate()
}

private fun String.removeDuplicate(): String {
    val stackIndex = 1
    val distinctStack = Stack<Char>()
    val firstChar = this[0]
    distinctStack.push(firstChar)

    this.substring(stackIndex).forEach { ch ->
        distinctStack.removeDuplicatedTopOrAppendWith(ch)
    }
    return distinctStack.convertString()
}

private fun Stack<Char>.removeDuplicatedTopOrAppendWith(ch: Char) {
    val top = peek()
    when {
        previousChar == ch && isContinuous -> return
        top == ch -> setStackStatus(true, pop())
        top != ch -> {
            setStackStatus(false, ch)
            push(ch)
        }
    }
}

private fun setStackStatus(_isContinuous: Boolean, _previousChar: Char) {
    isContinuous = _isContinuous
    previousChar = _previousChar
}

private fun Stack<Char>.convertString(): String {
    val emptyString = ""

    return this.fold(emptyString) { string, ch ->
        string.plus(ch)
    }
}