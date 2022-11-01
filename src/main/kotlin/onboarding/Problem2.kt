package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {
    val stack = Stack<Char>()
    for (ch in cryptogram) {
        if (!stack.empty() && stack.peek() == ch) {
            stack.pop()
        } else {
            stack.push(ch)
        }
    }
    TODO()
}
