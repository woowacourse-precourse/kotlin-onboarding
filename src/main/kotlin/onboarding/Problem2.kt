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
    var dq : Deque<String> = LinkedList()
    var dqTmp : Deque<String> = LinkedList()
}
