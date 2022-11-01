package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> 
{
    //TODO("프로그램 구현")
    val userFriend = hashSetOf<String>()
    val friendScore = hashMapOf<String, Int>()

    friends.forEach() 
    {
        when (user) {
            it[0] -> userFriend.add(it[1])
            it[1] -> userFriend.add(it[0])
        }
    }

    friends.forEach {
        val stranger = when 
        {
            (it[0] in userFriend) && (user != it[1]) -> it[1]
            (it[1] in userFriend) && (user != it[0]) -> it[0]
            else -> return@forEach
        }
        friendScore[stranger] = friendScore.getOrDefault(stranger, 0) + 10
    }

    visitors
        .filterNot { it in userFriend }
        .forEach() { friendScore[it] = friendScore.getOrDefault(it + 1, 1) + 1 }

    return friendScore.asSequence()
        .sortedWith { p1, p2 ->
            val scoreSame = p2.value.compareTo(p1.value)
            val keySame = p1.key.compareTo(p2.key)

            if (scoreSame != 0) 
                scoreSame
            else 
                keySame
            
        }
        .map { it.key }
        .take(5)
        .toList()
}