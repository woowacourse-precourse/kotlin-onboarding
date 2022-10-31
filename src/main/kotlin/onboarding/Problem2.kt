package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {
    val stack = Stack<Char>()
    var seqChar: Char? = null
    cryptogram.forEach { c ->
        if (c == seqChar) {
            return@forEach
        }

        seqChar = if (stack.isNotEmpty() && stack.peek() == c) {
            stack.pop()
            c
        } else {
            stack.add(c)
            null
        }
    }

    return stack.joinToString("")
}