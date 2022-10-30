package onboarding

fun main(args: Array<String>) {
    val user = "mrko"
    val friends = listOf(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    )
    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
    println(solution7(user, friends, visitors))
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendRelation: HashMap<String, MutableSet<String>> = createFriendRelation(friends = friends)
    val userFriends = friendRelation[user] ?: mutableSetOf()
    val recommendScores = hashMapOf<String, Int>()
    val result = mutableListOf<String>()

    initScores(
        recommendScores = recommendScores,
        user = user,
        friendRelation = friendRelation,
        visitors = visitors
    )
    println(recommendScores)

    recommendScores.keys.forEach { friend ->
        recommendScores[friend] = calcRecommendScore(
            friend = friend,
            friendRelation = friendRelation,
            userFriends = userFriends,
            visitors = visitors
        )
    }

    println(recommendScores)
    return result.toList()
}

fun initScores(
    recommendScores: HashMap<String, Int>,
    user: String,
    friendRelation: HashMap<String, MutableSet<String>>,
    visitors: List<String>
) {
    friendRelation.keys.forEach { name ->
        if (name != user) recommendScores[name] = 0
    }
    visitors.forEach { name ->
        recommendScores[name] = 0
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
): Int = calcAcquaintanceScore(friend = friend, friendRelation = friendRelation, userFriends = userFriends) + calcVisitorScore(friend = friend, visitors = visitors)

fun calcAcquaintanceScore(
    friend: String,
    friendRelation: HashMap<String, MutableSet<String>>,
    userFriends: MutableSet<String>
): Int {
    var acquaintanceNum = 0
    friendRelation[friend]?.forEach { name ->
        acquaintanceNum = userFriends.count { acquaintance ->
            acquaintance == name
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