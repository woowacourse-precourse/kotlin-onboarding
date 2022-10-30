package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
        val knowEachList = findFriends(user,friends)
        val knowEachSet = knowEachList.toSet()
    return listOf("")
}
fun	findFriends(user:String ,friends: List<List<String>>,):MutableList<String>{

    var friendsML = friends.toMutableList()
    var findedFriends = mutableListOf<String>(user)
    var friendsSet = mutableListOf<String>()

    for(i in 0..1){
        var count = findedFriends.size

        for(j in 0 until count){

            val person = findedFriends.removeAt(0)
            var k = 0
            while(k < friendsML.size){

                if(friendsML[k][0] == person)
                {
                    findedFriends.add(friendsML[k][1])
                    friendsML.removeAt(k)
                    k--
                }
                else if(friendsML[k][1] == person)
                {
                    findedFriends.add(friendsML[k][0])
                    friendsML.removeAt(k)
                    k--
                }
                k++
            }

        }

        if (i==0){
            friendsSet = findedFriends
        }
    }
    findedFriends.add(friendsSet.toString())
    return findedFriends
}
