package onboarding

fun get_user_friend(user : String, friends: List<List<String>>) : List<String>
{
    var user_friend :MutableList<String> = emptyList<String>().toMutableList()
    for (i in friends.indices)
    {
        if(user == friends[i][1] && friends[i][1] !in user_friend)
            user_friend.add(friends[i][0])
    }
    println(user_friend)
    return user_friend;
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var ans : List<String> = listOf("string")
    var user_friend =get_user_friend(user, friends)// user 와 친구인사람들 리스트


    return ans;
}

fun main() {
    val user = "mrko"
    val friends = listOf(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    )
    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
    val result = solution7(user,friends,visitors)
}