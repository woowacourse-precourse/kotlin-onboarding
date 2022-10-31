package onboarding

import java.util.Stack

/**
 * 기능 요구사항
 * - 연속하는 중복 문자들을 삭제
 * 풀이 방법
 * - 연속되는 짝을 찾기위해 Stack 의 마지막 문자와 현재 들어올 문자를 비교
 * - 먼저 index 를 이동하며 문자의 연속성을 비교한다
 * - 1. 같을때 (중복)
 *      - 1-1. 해당 index 부터 현재 Stack 의 마지막 문자와 다를 때까지 index 이동
 *      - 1-2. 달라지면 연속이 끝났으므로 현재 문자를 지우고 다시 새로운 Stack 의 마지막 문자로 연속 확인
 * - 2. 다르면 push()
 *      - 2-1 다른 문자를 push()
 *      - 2-2 Stack 의 마지막 문자로 비교할 문자를 변경
 * 예외사항 생각
 * - 1. Stack 이 비어있을때 exception 확인
 */
fun solution2(cryptogram: String): String {
    // 암호해독
    return decodeCryptogram(cryptogram)
}

private fun decodeCryptogram(cryptogram: String): String {
    val stack = Stack<Char>().apply {
        push(cryptogram[0])
    }
    val len = cryptogram.length
    var index = 1
    var buffer = stack.peek()
    while (index < len) {
        // 문자가 같을때
        if (cryptogram[index] == buffer) {
            stack.pop()
            // 같은 문자들 패스
            while (cryptogram[index] == buffer) {
                // 마지막 문자
                if (index == len - 1) {
                    index++
                    break
                }
                index++
            }
            if (stack.isNotEmpty()) {
                buffer = stack.peek()
            }
        } else {
            stack.push(cryptogram[index])
            buffer = stack.peek()
            index++
        }
    }
    // Stack 의 내부 그대로 문자열로 리턴
    return stack.joinToString("") { it.toString() }
}

