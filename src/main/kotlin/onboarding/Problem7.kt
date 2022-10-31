package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var result = mutableListOf<String>()
    var score: HashMap<String, Int> //점수 해쉬맵
    var myFriends = mutableListOf<String>() // 나의 친구들

    //친구 찾기
    fun findMyFriends(friends: List<List<String>>): MutableList<String> {
        var MyFriends = mutableListOf<String>()
        for (i in 0..friends.size - 1) {
            if (user.equals(friends[i][0])) {
                MyFriends.add(friends[i][1])
            }
            if (user.equals(friends[i][1])) {
                MyFriends.add(friends[i][0])
            }
        }
        return MyFriends
    }
    return result
}
