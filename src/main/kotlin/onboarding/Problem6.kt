package onboarding

import java.util.regex.Pattern

/**
 * 제약조건 검사 함수
 * - 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
 * - 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
 * - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
 *
 * @author @ponopono0322
 * @param craw 신청받은 크루 목록 or 크루 [이메일, 닉네임]
 * @return true: 제약조건 충분, false: 제약조건 불충분
 */
fun constraintsS6(craw: List<String>): Boolean {
    if (craw[0].split("@").last() != "email.com") return false
    if (craw[0].length !in 11 until 20) return false
    if (!Pattern.matches("^[ㄱ-ㅎ가-힣]*$", craw[1])) return false
    if (craw[1].length !in 1 until 20) return false

    return true
}


/**
 * 계정에서 가능한 조합 반환하는 함수
 *
 * @author @ponopono0322
 * @param nickname 닉네임
 * @return 닉네임으로 만들 수 있는 2글자 조합
 */
fun getNickSet(nickname: String): Set<String> {
    return (0 until nickname.length - 1).map { i ->
        nickname.substring(i until i + 2) }.toSet()
}


/**
 * Solution Algorithm
 * 1. 신청한 크루 목록이 1 ~ 10000 사이에 있는지 검사. 조건 불충분시 빈 배열 반환
 * 2. 신청 목록을 순회하면서
 * 3. 각 계정별 닉네임 2글자 조합 저장
 * 4. {key: email, value: 3의 결과} 해시맵(nameHash) 저장
 * 5. 3을 전체 계정 목록(uniqueNick)에 추가
 * 6. 4와 비교하여 중복된 조합을 공통 계정 목록(commonNick)에 추가
 * 7. 2가 종료된 후 4를 순회하면서
 * 8. 6의 결과가 있다면 배열(answer)에 추가
 * 9. 정렬된 8의 결과를 반환
 *
 * @author @ponopono0322
 * @param forms 신청 크루 목록
 * @return 중복 닉네임의 이메일 정렬 배열
 */
fun solution6(forms: List<List<String>>): List<String> {
    // 크루는 1명 이상 10,000명 이하이다.
    if (forms.size !in 1 .. 10000) return listOf()

    val answer = arrayListOf<String>()          // 중복되는 이메일 저장하는 배열
    var uniqueNick = setOf<String>()     // 전체 계정에서 나온 2글자 조합
    var commonNick = setOf<String>()     // 그 중 겹치는 조합
    val crawHash = HashMap<String, Set<String>>()   // 이메일: 2글자 조합 해시맵

    forms.forEach { craw ->
        if (!constraintsS6(craw)) return@forEach    // 조건에 부합하지 않는 경우는 pass

        val userNick = getNickSet(craw.last()) // 계정에서 가능한 조합
        crawHash[craw.first()] = userNick           // 해시맵에 저장

        if (uniqueNick.intersect(userNick).isNotEmpty()) {
            commonNick = commonNick.union(uniqueNick.intersect(userNick))
        }
        uniqueNick = uniqueNick.union(userNick)
    }

    // 해시맵 순회하면서 불가능한 이메일 저장
    crawHash.forEach { (k, v) ->
        if (commonNick.intersect(v).isNotEmpty()) { answer.add(k) }
    }

    return answer.sorted()
}
