package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}

private fun String.removeDuplicate(): String {
    val stackIndex = 1
    val notDuplicatedStack = Stack<Char>().apply {
        this.push(this[0])
    }

    this.substring(stackIndex).forEach { ch ->
        notDuplicatedStack.filterDuplicatedLastOrAppendWith(ch)
    }
    return notDuplicatedStack.convertString()
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