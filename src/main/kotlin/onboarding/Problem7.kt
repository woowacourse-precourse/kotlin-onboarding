package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendRelation: HashMap<String, MutableSet<String>> = createFriendRelation(friends = friends)
    val userFriends = friendRelation[user] ?: mutableSetOf()
    val recommendScores = hashMapOf<String, Int>()
    val result = mutableListOf<String>()

    // 추천 점수 정보 초기화
    initScores(
        recommendScores = recommendScores,
        user = user,
        friendRelation = friendRelation,
        visitors = visitors
    )

    // 추천 점수 계산
    recommendScores.keys.forEach { friend ->
        recommendScores[friend] = calcRecommendScore(
            friend = friend,
            friendRelation = friendRelation,
            userFriends = userFriends,
            visitors = visitors
        )
    }

    // 추천 대상 결정 및 정렬
    recommendFriend(recommendScores = recommendScores, result = result)

    return result.toList().take(MAX_RECOMMEND_NUM)
}

fun recommendFriend(recommendScores: HashMap<String, Int>, result: MutableList<String>) {

    // 점수 기준 내림차순, 이름 기준 오름차순
    recommendScores.toList().sortedWith(
        compareBy(
            { -it.second },
            { it.first }
        )
    ).forEach { (name, _) ->
        result.add(name)
    }
}

fun initScores(
    recommendScores: HashMap<String, Int>,
    user: String,
    friendRelation: HashMap<String, MutableSet<String>>,
    visitors: List<String>
) {
    friendRelation.keys.forEach { name ->
        recommendScores[name] = 0
    }
    visitors.forEach { name ->
        recommendScores[name] = 0
    }

    recommendScores.remove(user) // 자기 자신은 제거한다.

    friendRelation[user]?.forEach { directFriend ->
        recommendScores.remove(directFriend) // 자신과 직접 아는 친구는 추천할 필요가 없으므로 제거한다.
    }
}

fun createFriendRelation(friends: List<List<String>>): HashMap<String, MutableSet<String>> {
    val friendRelation = hashMapOf<String, MutableSet<String>>()

    friends.forEach { (friendA, friendB) ->
        friendRelation[friendA]?.add(friendB) ?: run {
            friendRelation[friendA] = mutableSetOf(friendB)
        }

        friendRelation[friendB]?.add(friendA) ?: run {
            friendRelation[friendB] = mutableSetOf(friendA)
        }
    }

    return friendRelation
}

fun calcRecommendScore(
    friend: String,
    friendRelation: HashMap<String, MutableSet<String>>,
    userFriends: MutableSet<String>,
    visitors: List<String>
): Int = calcAcquaintanceScore(
    friend = friend,
    friendRelation = friendRelation,
    userFriends = userFriends
) + calcVisitorScore(friend = friend, visitors = visitors)

fun calcAcquaintanceScore(
    friend: String,
    friendRelation: HashMap<String, MutableSet<String>>,
    userFriends: MutableSet<String>
): Int {
    var acquaintanceNum = 0
    friendRelation[friend]?.forEach { name ->
        acquaintanceNum += userFriends.count { directFriend ->
            directFriend == name
        }
    }

    return acquaintanceNum * ACQUAINTANCE_SCORE
}

fun calcVisitorScore(friend: String, visitors: List<String>): Int {
    val visitNum = visitors.count { visitor ->
        visitor == friend
    }

    return visitNum * VISITOR_SCORE
}

const val MAX_RECOMMEND_NUM = 5
const val ACQUAINTANCE_SCORE = 10
const val VISITOR_SCORE = 1