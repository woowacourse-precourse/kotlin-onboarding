package onboarding

import java.util.regex.Pattern

/**
 * 제약조건 함수
 * - user는 길이가 1 이상 30 이하인 문자열이다.
 * - friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
 * - visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
 *
 * @author @ponopono0322
 * @param user 추천하려는 사람
 * @param friends 관계 리스트
 * @param visitors user 방문 목록
 * @return true: 제약조건 만족시, false: 제약조건 위반시
 */
fun constraintsS7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): Boolean {
    if (user.length !in 1..30) return false
    if (friends.size !in 1 .. 10000) return false
    if (visitors.size !in 0 .. 10000) return false

    return true
}

/**
 * 제약조건 함수
 *
 * - 아이디는 길이가 1 이상 30 이하인 문자열이다.
 * - 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
 * @author @ponopono0322
 * @param name 사용자 아이디
 * @return true: 제약조건 만족시, false: 제약조건 불만족시
 */
fun nameCheck(name: String): Boolean {
    if (name.length !in 1 .. 30) return false
    if (!Pattern.matches("^[a-z]*$", name)) return false

    return true
}

/**
 * 사용자간 알고 있는 사람 해시맵 함수
 *
 * @author @ponopono0322
 * @param friends 알고 있는 사람 배열
 * @return 사용자간 알고 있는 사람 해시맵
 */
fun getFriendsHash(friends: List<List<String>>): MutableMap<String, Set<String>> {
    // 사용자간 알고 있는 사람 해시맵
    val friendsMap = HashMap<String, Set<String>>().withDefault { mutableSetOf() }

    // 사용자간 알고 있는 사람 갱신
    friends.forEach { (a, b) ->
        if (!nameCheck(a) || !nameCheck(b)) return@forEach
        friendsMap[a] = friendsMap.getValue(a) + setOf(b)
        friendsMap[b] = friendsMap.getValue(b) + setOf(a)
    }

    return friendsMap
}

/**
 * 추천 알고리즘 점수 해시맵
 *
 * @author @ponopono0322
 * @param user set 형식의 유저 아이디
 * @param visitors 방문 유저 목록
 * @param knowFriends 사용자간 알고 있는 유저 해시맵
 * @return 추천 알고리즘 점수 해시맵
 */
fun getRecommendHash(
    user: String,
    visitors: List<String>,
    knowFriends: MutableMap<String, Set<String>>
): MutableMap<String, Int> {
    // 추천 점수 저장하는 해시맵
    val recommendMap = HashMap<String, Int>().withDefault { 0 }
    val subFriend = knowFriends.getValue(user).union(setOf(user))

    if (knowFriends.getValue(user).isNotEmpty()) {
        knowFriends.keys.subtract(subFriend).forEach { n ->
            recommendMap[n] = knowFriends.getValue(n).size * 10
        }
    }

    // 방문자에 의한 사용자 추천 점수 갱신
    visitors.forEach { n ->
        if (!knowFriends.getValue(user).contains(n)) {
            recommendMap[n] = recommendMap.getValue(n) + 1
        }
    }

    return recommendMap
}

/**
 * Solution Algorithm
 *
 * 1. 각 사용자 별로 아는 사람(set) 해시맵 저장(knowFriends)
 * 2. 방문자를 순회하면서 사용자별 추천 점수 해시맵 저장(recommendFriends)
 * 3. user의 지인 확인(아무도 없다면 4는 스킵)
 * 4. 모르고 있는 지인의 수 * 10
 * 5. 방문자가 user와 아는 사이인지 확인 (+1)
 * 6. 2를 리스트로 변환, 점수는 내림차순, 사용자 이름은 오름차순으로 정렬
 * 7. 0을 제외한 최대 5개의 사용자 반환
 *
 * @author @ponopono0322
 * @param user 추천하려는 사람
 * @param friends 관계 리스트
 * @param visitors user 방문 목록
 * @return 추천 사용자 목록
 */
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // 제약조건 위반시
    if (!constraintsS7(user, friends, visitors)) return listOf()
    // 사용자간 알고 있는 사람 해시맵
    val knowFriends = getFriendsHash(friends)
    // 추천 점수 저장하는 해시맵
    val recommendFriends = getRecommendHash(user, visitors, knowFriends)
    // 점수에 의해 정렬된 목록
    val sortedFriends = recommendFriends.toList().sortedWith(compareBy({ -it.second }, { it.first }))
    // 최대 5명, 점수가 0보다 큰 유저 목록
    return sortedFriends.take(5).filter { it.second > 0 }.map { it.first }
}
