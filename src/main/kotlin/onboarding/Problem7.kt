package onboarding

private var friendsCopy = mutableListOf<MutableList<String>>()
private var myFriends = mutableListOf<String>()
private var recommmedPoint = HashMap<String,Int>()
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    for(i in 0 until friends.size){
        friendsCopy.add(i,friends[i].toMutableList())
    }

    addMyFriend(user,friends)
//    setPoint(user, friends, visitors)

    var resultSort = mutableListOf<Pair<String,Int>>()
    for(i in recommmedPoint){
        resultSort.add(Pair(i.key,i.value))
    }
    resultSort.sortBy {
        it.second
    }
    var result = mutableListOf<String>()
    for(i in resultSort){
        result.add(i.first)
    }
    return result.toList()
}
private fun addMyFriend(user : String, friends : List<List<String>>){
    for(i in friends){
        if(i[0]==user){
            myFriends.add(i[1])
            friendsCopy.remove(i)
        }
        else if(i[1]==user){
            myFriends.add(i[0])
            friendsCopy.remove(i)
        }
    }
}
//