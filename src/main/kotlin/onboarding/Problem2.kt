package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {
    val stack = Stack<Char>()
    cryptogram.forEach { c ->
        if (stack.isNotEmpty() && stack.peek() == c) {
            stack.pop()
        } else {
            stack.add(c)
        }
    }
    return stack.joinToString("")
}
