package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var fv = mutableListOf<String>()
    var user_friends = mutableListOf<String>()
    for ( i in 0..friends.size-1){
        if (friends[i][0] == user)
            user_friends.add(friends[i][1])
        if (friends[i][1] == user)
            user_friends.add(friends[i][0])

    }
    for (i in 0..friends.size-1){
        fv.add(friends[i][0])
        fv.add(friends[i][1])
    }
    for (i in 0..visitors.size-1){
        fv.add(visitors[i])
    }
    fv=fv.distinct().toMutableList()
    fv.remove(user)
    var point : MutableList<Int> = MutableList<Int>(fv.size) {0}




    for(i in 0..point.size-1){
       point[i] += visitors.count(){it == fv[i]}

    }
    var result = mutableMapOf<String,Int>()
    for (i in 0..fv.size-1){
        result.put(fv[i],point[i])
    }


    for (i in 0..friends.size-1){
        for(j in 0..user_friends.size-1) {
            if (friends[i][0] == user_friends[j] && friends[i][1] != user)
                result.replace(friends[i][1],result.getValue(friends[i][1])+10)
            if (friends[i][1] == user_friends[j] && friends[i][0] != user )
                result.replace(friends[i][0],result.getValue(friends[i][1])+10)
        }
    }
    result = result.toList().sortedByDescending { it.second  }.toMap()as MutableMap<String, Int>
    var resultkey = result.keys.toList()
    var resultlist = listOf<String>(resultkey[0],resultkey[1],resultkey[2])

    return resultlist.toList()

}
