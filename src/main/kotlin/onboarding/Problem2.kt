package onboarding

import java.util.Stack

fun solution2(cryptogram: String): String {

    val sb = StringBuilder()
    // 스택에 문자를 push한다.
    val decode = decode(cryptogram)

    // 스택을 StringBulider에 넣고 String으로 형변환하여 반환한다
    decode.forEach {
        sb.append(it)
    }

    return sb.toString()
}

private fun decode(cryptogram: String): Stack<Char> {
    val stack = Stack<Char>()

    cryptogram.forEach {
        if(stack.isEmpty()) {
            stack.push(it)
        } else {
            // 스택에 문자가 있으면 peek을 해서 push해야할 문자와 같은지 확인한다.
            if(stack.containsLast(it)) {
                stack.pop()
                return@forEach
            }
            // 같으면 pop하고 push하지 않는다.
            stack.push(it)
        }
    }

    return stack
}

private fun Stack<Char>.containsLast(char: Char): Boolean {
    return peek() == char
}

