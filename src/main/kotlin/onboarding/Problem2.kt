package onboarding

import java.util.Stack

/**
 * 기능 요구사항
 * - 연속하는 중복 문자들을 삭제
 * 풀이 방법
 * - 연속되는 짝을 찾기위해 Stack 의 마지막 문자와 현재 들어올 문자를 비교
 * - 1. 같으면 pop()
 * - 2. 다르면 push()
 * 예외사항 생각
 * - 1. Stack 이 비어있을때 exception 확인
 */
fun solution2(cryptogram: String): String {
    // 암호해독
    return decodeCryptogram(cryptogram)
}

private fun decodeCryptogram(cryptogram: String): String {
    val stack = Stack<Char>()
    for (char in cryptogram) {
        if (stack.isNotEmpty()) {
            if (stack.peek() == char) {
                stack.pop()
            } else {
                stack.push(char)
            }
        } else {
            stack.push(char)
        }
    }
    // Stack 의 내부 그대로 문자열로 리턴
    return stack.joinToString("") { it.toString() }
}

