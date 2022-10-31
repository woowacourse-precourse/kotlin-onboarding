package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendsRelationshipHashMap = HashMap<String, MutableList<String>>()
    val recommendedFriendHashMap = HashMap<String, Int>()
    val scoreList = mutableListOf<RecommendedFriend>()
    val result = mutableListOf<String>()

    for (i in friends.indices) { // 각자의 친구 목록 생성.
        if (friendsRelationshipHashMap.containsKey(friends[i][0])) {
            friendsRelationshipHashMap[friends[i][0]]?.add(friends[i][1])
        } else {
            friendsRelationshipHashMap[friends[i][0]] = mutableListOf(friends[i][1])
        }

        if (friendsRelationshipHashMap.containsKey(friends[i][1])) {
            friendsRelationshipHashMap[friends[i][1]]?.add(friends[i][0])
        } else {
            friendsRelationshipHashMap[friends[i][1]] = mutableListOf(friends[i][0])
        }
    }

    val userFriendsSet = friendsRelationshipHashMap[user]?.toSet() ?: setOf()
    for (userFriend in userFriendsSet.toList()) {
        val hisFriends = friendsRelationshipHashMap[userFriend] ?: listOf()
        for (friendFromFriend in hisFriends) {
            if (friendFromFriend in userFriendsSet || friendFromFriend==user) { // 이미 user와 친구인 친구는 제외.
                continue
            }

            if (recommendedFriendHashMap.containsKey(friendFromFriend)) {
                recommendedFriendHashMap[friendFromFriend] = recommendedFriendHashMap[friendFromFriend]!! + 10
            } else {
                recommendedFriendHashMap[friendFromFriend] = 10
            }
        }
    }

    for (visitor in visitors){
        if (visitor in userFriendsSet){
            continue
        }

        if (recommendedFriendHashMap.containsKey(visitor)) {
            recommendedFriendHashMap[visitor] = recommendedFriendHashMap[visitor]!! + 1
        } else {
            recommendedFriendHashMap[visitor] = 1
        }
    }

    for (person in recommendedFriendHashMap.keys){
        scoreList.add(RecommendedFriend(person, recommendedFriendHashMap[person]!!))
    }
    scoreList.sortWith(compareBy({ -it.score }, { it.name }))

    for (s in scoreList) {
        result.add(s.name)
    }
    return result
}

data class RecommendedFriend(
    val name: String,
    var score: Int
)


