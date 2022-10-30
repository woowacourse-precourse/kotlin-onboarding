package onboarding
fun solution7mappingToInt(friends:List<List<String>>, visitors:List<String>) : HashMap<String, Int>{
    val friendsId=HashMap<String, Int>()
    friends.forEach { friendRelation ->
        val (friendA, friendB)=arrayOf(friendRelation[0], friendRelation[1])
        var id=0

        if(!friendsId.containsKey(friendA)){
            friendsId[friendA]=id++
        }

        if(!friendsId.containsKey(friendB)){
            friendsId[friendB]=id++
        }
    }

    return friendsId
}


fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {

}


