package onboarding

fun Init_friends_score(friends: List<List<String>>, visitors: List<String>): MutableMap<String,Int>
{
    var dic : MutableMap<String,Int> = emptyMap<String,Int>().toMutableMap()

    for(i in friends.indices)
    {
        dic[friends[i][0]] = 0
        dic[friends[i][1]] = 0
    }
    for(i in visitors.indices)
    {
        dic[visitors[i]] = 0
    }
    println("dic= "+dic)
    return dic
}
fun get_score(user_friend : List<String>, friend_a: String) : Int{
    var score :Int = 0
    if(friend_a in user_friend)
        score +=10
    println("friend: "+friend_a+" score = "+score)
    return score
}
fun get_user_friend(user : String, friends: List<List<String>>) : List<String>
{
    var user_friend :MutableList<String> = emptyList<String>().toMutableList()
    for (i in friends.indices)
    {
        if(user == friends[i][1] && friends[i][1] !in user_friend)
            user_friend.add(friends[i][0])
    }
    println("user_friend = "+user_friend)
    return user_friend;
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var score_dic = Init_friends_score(friends,visitors)
    var user_friend =get_user_friend(user, friends)// user 와 친구인사람들 리스트

    for (i in friends.indices)
    {
        if(friends[i][1] == user)
            continue
        else if(friends[i][0] in user_friend) {
            var tmp_score: Int = get_score(user_friend, friends[i][0])
            score_dic[friends[i][1]] = tmp_score + score_dic[friends[i][1]]!! //!!붙이는 이유? 알아볼것
        }
    }
    for (i in visitors.indices)
    {
        if (visitors[i] in user_friend)
            continue
        score_dic[visitors[i]] = 1+ score_dic[visitors[i]]!!
    }
    println(score_dic)
    //return result;
    return friends[0]
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