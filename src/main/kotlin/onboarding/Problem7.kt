package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    /**
     * 기능목록
     * 1. 아이디와 점수를 담을 MutableMap 선언, user의 친구들을 담을 ArrayList 선언
     * 2. friends에서 user 친구들을 ArrayList에 할당(for)
     * 3. ArrayList의 요소들과 friends 요소들을 체크하여 MutableMap에 담고 10점 추가(for)
     * 4. visitors 목록을 MutableMap에 할당하고 횟수 당 1점 추가
     * 5. MutableMap의 Value를 기준으로 정렬 후 리턴
     * */

    /** 1. 아이디와 점수를 담을 MutableMap 선언, user의 친구들을 담을 ArrayList 선언 */
    var idScoreMap: MutableMap<String, Int> = mutableMapOf()
    var listOfFriends: ArrayList<String> = ArrayList()

    /** 2. friends에서 user 친구들을 ArrayList에 할당(for) */
    for (friend in friends) {
        if (friend.contains(user)) {
            if (friend[0] == user) {
                listOfFriends.add(friend[1])
            }
            if (friend[1] == user) {
                listOfFriends.add(friend[0])
            }
        }
    }

    /** 3. ArrayList의 요소들과 friends 요소들을 체크하여 MutableMap에 담고 10점 추가(for) */
    for (friend in listOfFriends) {
        for (coFriend in friends) {
            if (coFriend.contains(friend)) {
                if (coFriend[0] == friend) {
                    idScoreMap[coFriend[1]] = idScoreMap[coFriend[1]]?.plus(10) ?: 10
                }
                if (coFriend[1] == friend) {
                    idScoreMap[coFriend[0]] = idScoreMap[coFriend[0]]?.plus(10) ?: 10
                }
            }
        }
    }

    /** 4. visitors 목록을 MutableMap에 할당하고 횟수 당 1점 추가 */
    for (visitor in visitors) {
        idScoreMap[visitor] = idScoreMap[visitor]?.plus(1) ?: 1
    }
}
