package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var friendstr : Array<String> = emptyArray()
    var friendInt : Array<Int> = emptyArray()

    friends.forEach(){ friend ->
        if (friend[0].equals(user)){
            if (friendstr.(friend[1])){
                var tmp = friendstr.indexOf(friend[1])
                friendInt[tmp] += 10
            }else{
                friendstr.plus(friend[1])
                friendInt.plus(10)
            }
        }else if (friend[1].equals(user)){
            if (friendstr.contains(friend[0])){
                var tmp = friendstr.indexOf(friend[0])
                friendInt[tmp] += 10
            }else{
                friendstr.plus(friend[0])
                friendInt.plus(10)
            }
        }

    }
    visitors.forEach(){ visitor ->
        if(friendstr.contains(visitor)){
            var tmp = friendstr.indexOf(visitor)
            friendInt[tmp] += 10
        }else{
            friendstr.plus(visitor)
            friendInt.plus(1)
        }
    }

    var friendMap : Map<String, Int> = friendstr
            .zip(friendInt).toMap()

    var friendPairList = friendMap.toList()
    friendPairList = friendPairList.sortedByDescending { it.second }
            .slice(0 until 5)

    var newMap = friendPairList.toMap()

    return newMap.keys.toList()
}
