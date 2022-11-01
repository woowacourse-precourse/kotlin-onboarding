package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val user = user
    val friends = friends
    val visitors = visitors
    var friendsOfUser = ArrayList<String>()
    var indexArray = ArrayList<Int>()
    var recommendScore = mutableMapOf<String, Int>()
    var result = ArrayList<String>()
}

/**
유저와 친구인 사람의 이름과 전달받은 배열에서의 index를 저장하는 기능
 */
fun findFriendsOfUser(user: String, friends: List<List<String>>, friendsOfUser: ArrayList<String>, indexArray: ArrayList<Int>){
    for (index in friends.indices){
        if (friends[index].indexOf(user) != -1){ //user의 이름을 포함한다면
            friendsOfUser.add(friends[index][1 - friends[index].indexOf(user)]) // 배열에 user 옆에 사람의 이름을 저장하고
            indexArray.add(index) // 그 해당 index도 저장한다.
        }
    }
}

/**사용자와 함께 아는 친구 점수를
 * recommendScore 맵에 key = 이름, value = 점수 형태로 저장해주는 기능
 * 전달받은 배열만큼 반복문을 돌려 사용자의 친구가 배열 index 번 째에 존재한다면,
 * 그 index 번째의 친구를 맵에 저장하고
 * 만약에 이미 맵에 저장된 상태라면 value 값에 10을 더해준다.
 */
fun addScoreByFriends(friends: List<List<String>>,
                      friendsOfUser: ArrayList<String>,
                      indexArray: ArrayList<Int>,
                      recommendScore: MutableMap<String, Int>){
    for (index in friends.indices){
        if (indexArray.contains(index)) continue // 사용자가 속한 인덱스는 continue
        for (index2 in friendsOfUser.indices){
            if (friends[index].indexOf(friendsOfUser[index2]) != -1){ // user의 친구를 포함할 때 ->else
                if (recommendScore.containsKey(friends[index][1 - friends[index].indexOf(friendsOfUser[index2])])){ //이때 이미 맵에 user의 친구와 친구 상태인 사람이 있다면
                    val string = friends[index][1 - friends[index].indexOf(friendsOfUser[index2])]
                    recommendScore[string] = recommendScore[string]?.plus(10)!! // value에 10을 더해줌
                }
                else{ // 맵에 key로는 user의 친구와 친구 상태인 사람으로, value는 10으로 저장
                    recommendScore[friends[index][1 - friends[index].indexOf(friendsOfUser[index2])]] = 10
                }
            }
        }
    }
}
