package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendMap = mutableMapOf<String, MutableList<String>>()
    val recommendList = mutableMapOf<String, Int>()

    friends.forEach { relationship ->
        friendMap[relationship[0]]?.add(relationship[1]) ?: friendMap.put(relationship[0], mutableListOf(relationship[1]))
        friendMap[relationship[1]]?.add(relationship[0]) ?: friendMap.put(relationship[1], mutableListOf(relationship[0]))
    }

    friendMap[user]?.forEach { friend ->
        friendMap[friend]?.forEach {
            if (it != user) {
                if (recommendList.containsKey(it)) recommendList[it] = recommendList[it]!! + 10
                else recommendList[it] = 10
            }
        }
    }

    visitors.forEach { visitor ->
        if (friendMap[user]?.contains(visitor) == false) {
            if (recommendList.containsKey(visitor)) recommendList[visitor] = recommendList[visitor]!! + 1
            else recommendList[visitor] = 1
        }
    }

    val result = recommendList.toList().sortedWith(compareBy ({ -(it.second) }, {it.first})).take(5)

    return result.map { it.first }
}
