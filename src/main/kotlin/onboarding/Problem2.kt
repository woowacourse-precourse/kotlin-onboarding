package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {
    val stack = Stack<Char>()
    cryptogram.map {
        if (!stack.isEmpty()) {
            if (stack.peek() != it) {
                stack.push(it)
            } else {
                stack.pop()
            }
        } else {
            stack.push(it)
        }
    }
    return stack.joinToString("")
}
