package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    return cryptogram.removeDuplicate()
}

private fun String.removeDuplicate(): String {
    val stackIndex = 1
    val distinctStack = Stack<Char>()
    distinctStack.push(this[0])

    this.substring(stackIndex).forEach { ch ->
        distinctStack.filterDuplicatedLastOrAppendWith(ch)
    }
    return distinctStack.convertString()
}

private fun Stack<Char>.filterDuplicatedLastOrAppendWith(ch: Char) {
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