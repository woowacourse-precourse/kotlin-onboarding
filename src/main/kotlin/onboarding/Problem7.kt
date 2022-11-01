package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val result = knowingFriend(user, friends) + visitedFriend(user, friends, visitors)
    return result.toList().sortedByDescending { it.second }.toMap().keys.take(5)

}

fun alreadyFriend(user: String, friends: List<List<String>>) : ArrayList<String> {

    var alreadyFriend = ArrayList<String>()

    friends.forEach{
        if (it[0] == user){
            alreadyFriend.add((it[1]))
        } else if(it[1] == user){
            alreadyFriend.add(it[0])
        }
    }

    return alreadyFriend
}
fun knowingFriend(user: String, friends: List<List<String>>) : Map<String, Int> {

   // var alreadyFriend = ArrayList<String>()
    var score = mutableMapOf<String, Int>()
    val alreadyFriend = alreadyFriend(user, friends)

    friends.forEach{
        if(!it.contains(user) && alreadyFriend.contains(it[0])){
            score[it[1]] = score.getOrDefault(it[1], 0) + 10
        } else if(!it.contains(user) && alreadyFriend.contains(it[1])){
            score[it[0]] = score.getOrDefault(it[0], 0) + 10
        }
    }

    return score
}

fun visitedFriend(user: String, friends: List<List<String>>, visitors: List<String>) : Map<String, Int>{

    val alreadyFriend = alreadyFriend(user, friends)
    var score = mutableMapOf<String, Int>()

    visitors.forEach {
        if(!alreadyFriend.contains(it)){
            score[it] = score.getOrDefault(it, 0) + 1
        }
    }

    return score
}