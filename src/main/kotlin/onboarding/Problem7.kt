package onboarding

fun solution7(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    var userFriends = mutableSetOf<String>()
    var recommend = mutableMapOf<String, Int>()

    //사용자와 친구 관계를 맺고 있는 친구 리스트 만들기
    for (i in friends){
        if (i.contains(user)){
            for (j in (0..1)){
                userFriends.add(i[j])
            }
        }
    }
    userFriends.remove(user)

}
