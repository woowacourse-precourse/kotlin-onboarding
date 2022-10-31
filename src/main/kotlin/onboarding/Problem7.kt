package onboarding

fun setUserFriends(infoFriends: List<List<String>>, user: String): List<String> {
    var result = mutableListOf<String>()

    for(i in infoFriends.indices) {
        if (infoFriends[i][0] == user) {
            result.add(infoFriends[i][1])
            continue
        }
        if(infoFriends[i][1] == user)
            result.add(infoFriends[i][0])
    }

    return result.toList()
}

fun setWeAreFriends(userFriends: List<String>, infoFriends: List<List<String>>, user: String): Map<String, Int> {
    var result = mutableMapOf<String, Int>()

    for(i in infoFriends.indices) {
        if(infoFriends[i][0] == user || infoFriends[i][1] == user)
            continue

        if(!userFriends.find{it == infoFriends[i][0]}.isNullOrEmpty()) {
            if(result[infoFriends[i][1]] == null)
                result[infoFriends[i][1]] = 10
            else
                result[infoFriends[i][1]] = result[infoFriends[i][1]]!! + 10
        } else if(!userFriends.find{it == infoFriends[i][1]}.isNullOrEmpty()) {
            if(result[infoFriends[i][0]] == null)
                result[infoFriends[i][0]] = 10
            else
                result[infoFriends[i][0]] = result[infoFriends[i][0]]!! + 10
        }
    }

    return result.toMap()
}

fun setVisitor(score: Map<String, Int>, visitors: List<String>, userFriends: List<String>): Map<String, Int> {
    var result = score.toMutableMap()

    for(i in visitors.indices) {
        if(!userFriends.find{it == visitors[i]}.isNullOrEmpty()) {
            continue
        }
        if(result[visitors[i]] == null) {
            result[visitors[i]] = 1
        } else {
            result[visitors[i]] = result[visitors[i]]!! + 1
        }
    }

    return result.toMap()
}

fun setMapSort(score: Map<String, Int>): Map<String, Int> {
    var scoreList = score.toList()

    return scoreList.sortedWith(compareBy<Pair<String, Int>> { it.second }.reversed().thenBy { it.first }).toMap()
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriends = setUserFriends(friends, user)
    var scoreList = setWeAreFriends(userFriends, friends, user)
    scoreList = setVisitor(scoreList, visitors, userFriends)
    var result = setMapSort(scoreList)

    return if(result.size > 5)
        result.keys.toList().subList(0, 5)
    else
        result.keys.toList()
}
