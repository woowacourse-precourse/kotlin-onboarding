package onboarding
/*
1. 덱 2개를 선언
2. main deque은 문제의 요구사항에 맞게 알파벳을 담음
3. sub deque은 for문을 순회하며 모든 알파벳을 담음
4. 새로운 알파벳과 main deque의 마지막 알파벳이 같을 경우 poll
5. 새로운 알파벳과 sub deque의 마지막 알파벳이 같을 경우 continue
6. 4, 5를 만족하지 못할경우 main deque에 알파벳 추가
7. 최종적으로 main deque에 담긴 알파벳을 stringbuilder를 사용해 문자열로 만듦
*/
import java.util.*

fun solution2(cryptogram: String): String {
    // 1. 덱 2개를 선언
    // 2. main deque은 문제의 요구사항에 맞게 알파벳을 담음
    var dq: Deque<String> = LinkedList()
    // 3. sub deque은 for문을 순회하며 모든 알파벳을 담음
    var dqTmp: Deque<String> = LinkedList()

    var token = cryptogram.chunked(1)

    dq.offer(token[0])
    dqTmp.offer(token[0])
    for (i in 1 until token.size) {
        val tmp = token[i]
        // 4. 새로운 알파벳과 main deque의 마지막 알파벳이 같을 경우 poll
        if (dq.peekLast() == tmp) {
            dq.pollLast()
        // 5. 새로운 알파벳과 sub deque의 마지막 알파벳이 같을 경우 continue
        } else if (dqTmp.peekLast() == tmp) {
            continue
        // 6. 4, 5를 만족하지 못할경우 main deque에 알파벳 추가
        } else {
            dq.offer(tmp)
        }
        dqTmp.offer(tmp)
    }

    // 7. 최종적으로 main deque에 담긴 알파벳을 stringbuilder를 사용해 문자열로 만듦
    var sb = StringBuilder();

    while (!dq.isEmpty()) {
        sb.append(dq.poll())
    }
    return sb.toString()
}
