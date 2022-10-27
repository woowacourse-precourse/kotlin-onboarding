package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    return cryptogram.removeDuplicate()
}

private object StackStatus {
    var isContinuous = false
    var previousChar = ' '
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
        top == ch -> pop()
        top != ch -> push(ch)
    }
}

private fun Stack<Char>.convertString(): String {
    val emptyString = ""

    return this.fold(emptyString) { string, ch ->
        string.plus(ch)
    }
}