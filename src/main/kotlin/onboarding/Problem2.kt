package onboarding

import java.util.Stack

fun stackToString(stack: Stack<Char>): String {
    val sb = StringBuilder()
    while (!stack.empty()) {
        sb.append(stack.pop())
    }
    return sb.reverse().toString()
}

fun solution2(cryptogram: String): String {
    val stack = Stack<Char>()
    for (ch in cryptogram) {
        if (!stack.empty() && stack.peek() == ch) {
            stack.pop()
        } else {
            stack.push(ch)
        }
    }
    return stackToString(stack)
}
