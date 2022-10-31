package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

}

/**
 * 전체 유저의 리스트를 반환한다.
 */
fun getAllUserList(friends: List<List<String>>, visitors: List<String>): List<String> {
    val totalUserList = mutableListOf<String>()
    for (i in friends) {
        if (!totalUserList.contains(i[0])) {
            totalUserList.add(i[0])
        }
        if (!totalUserList.contains(i[1])) {
            totalUserList.add(i[1])
        }
    }
    for (i in visitors) {
        if (!totalUserList.contains(i)) {
            totalUserList.add(i)
        }
    }
    return totalUserList.toList()
}
/**
 * 유저와 이미 친구인 리스트를 반환한다.
 */

/**
 * 리스트에서 특정 문자열의 인덱스를 반환한다.
 */

/**
 * 리스트에서 특정 문자열의 갯수를 반환한다.
 */

/**
 * 함께 아는 친구 리스트를 반환한다.
 */

/**
 * 점수테이블에 타임라인에 방문한 친구들의 추천 점수를 더해 반환한다.
 */

/**
 * 친구리스트를 점수테이블과 비교하여 높은 순으로 정렬한 리스트를 반환한다.
 * 이 때 0점인 경우는 추가하지 않는다.
 */