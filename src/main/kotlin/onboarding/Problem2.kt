package onboarding

import java.util.*

fun solution2(cryptogram: String): String {
    val answer = removeDuplication(cryptogram)
    return toString(answer)
}

fun toString(stack: Stack<Char>): String {
    var answer = ""
    stack.forEach {
        answer += it
    }
    return answer
}

fun removeDuplication(cryptogram: String): Stack<Char> {
    val stack = Stack<Char>()

    cryptogram.forEach {
        if (stack.isEmpty()) stack.push(it)
        else {
            // 전에 문자와 같을 때 push 안함
            if (stack.peek() == it) {
                stack.pop()
                return@forEach
            }
            stack.push(it)
        }
    }
    return stack
}