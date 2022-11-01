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
    var save = '-'
    for (ch in cryptogram) {
        if (ch == save) {
            if (stack.peek() == ch) stack.pop()
            continue
        } else if (!stack.empty() && stack.peek() == ch) {
            stack.pop()
        } else {
            save = ch
            stack.push(ch)
        }
    }
    return stackToString(stack)
}
