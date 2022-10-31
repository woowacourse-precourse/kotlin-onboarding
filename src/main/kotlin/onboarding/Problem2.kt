package onboarding

import java.lang.StringBuilder
import java.util.Stack

/**
 * @author onseok
 */

fun solution2(cryptogram: String): String {
    val stack = Stack<Char>()
    val sb = StringBuilder()
    cryptogram.forEach {
        if (stack.size == 0) {
            stack.push(it)
        } else {
            if (it == stack.peek()) {
                stack.pop()
            } else {
                stack.push(it)
            }
        }
    }
    while (stack.isNotEmpty()) {
        sb.append(stack.pop())
    }
    return sb.reversed().toString()
}
