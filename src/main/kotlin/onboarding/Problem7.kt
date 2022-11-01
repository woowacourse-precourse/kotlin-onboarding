package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val foundFriendsList = findFriends(user,friends)
    val friendsList = foundFriendsList.first    //user의 친구
    val knowEachFriend = foundFriendsList.second //user의 친구의 친구

    return point(friendsList,knowEachFriend,visitors)
}

//user의 친구와 user의 함께 아는 친구 찾기
fun	findFriends(user:String ,friends: List<List<String>>,):Pair<MutableList<String>,MutableList<String>>{

    var friendsML = friends.toMutableList()
    var foundFriends = mutableListOf(user)
    var friendsSet = mutableListOf<String>()

    for(i in 0..1){
        var count = foundFriends.size

        for(j in 0 until count){

            val person = foundFriends.removeAt(0)
            var k = 0
            while(k < friendsML.size){

                if(friendsML[k][0] == person)
                {
                    foundFriends.add(friendsML[k][1])
                    friendsML.removeAt(k)
                    k--
                }
                else if(friendsML[k][1] == person)
                {
                    foundFriends.add(friendsML[k][0])
                    friendsML.removeAt(k)
                    k--
                }
                k++
            }

        }
        if (i==0){
            friendsSet = foundFriends.toMutableList()
        }
    }
    return Pair(friendsSet,foundFriends)
}

//함께 아는 친구면 10점 추가
//visit 횟수 만큼 1점 추가
fun point(friendsList:MutableList<String>,knowEachFriend:MutableList<String>,visitors:List<String>):List<String>{

    var visitorsML = mutableListOf<String>()

    for(i in visitors.indices)
        if (friendsList.indexOf(visitors[i])== -1)
            visitorsML.add(visitors[i])

    var namePointMap = mutableMapOf<String,Int>()
    for (i in knowEachFriend.indices){
        val kEF = knowEachFriend[i]
        if(!namePointMap.containsKey(kEF)){
            namePointMap.put(kEF,10)
            continue
        }
        val value= namePointMap.get(kEF)!!+10
        namePointMap.replace(kEF,value)
    }

    for (i in visitorsML.indices){
        val vML = visitorsML[i]
        if(!namePointMap.containsKey(vML)){
            namePointMap[vML] = 1
            continue
        }
        val value= namePointMap.get(vML)!!+1
        namePointMap.replace(vML,value)
    }

    var sortedPoint = namePointMap.toList().sortedWith(compareBy { it.first })
    sortedPoint = sortedPoint.sortedWith(compareByDescending { it.second })

    var result = mutableListOf<String>()
    for(i in sortedPoint.indices){
        result.add(sortedPoint[i].first)
    }
    return result
}
