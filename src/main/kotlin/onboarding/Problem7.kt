package onboarding

class FriendPoint(var name: String, var cnt: Int) {
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val directFriends : MutableSet<String> = mutableSetOf()
    val indirectFriends : MutableMap<String, Int> = mutableMapOf()
    //add direct friends
    for(friend in friends) {
        if(friend[0] == user) {
            directFriends.add(friend[1])
        }
        if(friend[1] == user) {
            directFriends.add(friend[0])
        }
    }
    //add indirect friends
    for(friend in friends) {
        if(friend[0] == user || friend[1] == user) {
            continue
        }
        if(directFriends.contains(friend[0])) {
            if(indirectFriends[friend[1]] == null) {
                indirectFriends[friend[1]] = 10
            }
            else {
                indirectFriends[friend[1]] = indirectFriends[friend[1]]!! + 10
            }
        }
        if(directFriends.contains(friend[1])) {
            if(indirectFriends[friend[0]] == null) {
                indirectFriends[friend[0]] = 10
            } else {
                indirectFriends[friend[0]] = indirectFriends[friend[0]]!! + 10
            }
        }
    }
    //find visitors
    for(visitor in visitors) {
        if(directFriends.contains(visitor)) {
            continue
        }
        if(indirectFriends[visitor] == null) {
            indirectFriends[visitor] = 1
        } else {
            indirectFriends[visitor] = indirectFriends[visitor]!! + 1
        }
    }
    val friendPointSet:MutableSet<FriendPoint> = mutableSetOf()
    //sort recommended friends
    for(indirectFriend in indirectFriends) {
        friendPointSet.add(FriendPoint(indirectFriend.key, indirectFriend.value))
    }
    val sortedFriends = friendPointSet.toList().sortedWith { a, b ->
        when {
            a.cnt > b.cnt -> 1
            a.cnt < b.cnt -> -1
            a.name < b.name -> 1
            a.name > b.name -> -1
            else -> 0
        }
    }.map{it.name}.reversed()
    if(sortedFriends.size > 5) {
        return sortedFriends.slice(0 .. 4)
    }
    return sortedFriends
}