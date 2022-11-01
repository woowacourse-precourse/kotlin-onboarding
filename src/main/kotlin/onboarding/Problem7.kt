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

    findFriendsOfUser(user, friends, friendsOfUser, indexArray)
    addScoreByFriends(friends, friendsOfUser, indexArray, recommendScore)
    addScoreByVisit(visitors, friendsOfUser, recommendScore)
    sortWithName(result, recommendScore)

    val finalResult = divideIntoFive(result.distinct()) //중복을 제거하고 5순위까지 자른 배열
    return finalResult
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
                      recommendScore: MutableMap<String, Int>) {
    for (index in friends.indices) {
        if (indexArray.contains(index)) continue // 사용자가 속한 인덱스는 continue
        for (index2 in friendsOfUser.indices) {
            if (friends[index].indexOf(friendsOfUser[index2]) != -1) { // user의 친구를 포함할 때 ->else
                if (recommendScore.containsKey(
                        friends[index][1 - friends[index].indexOf(
                            friendsOfUser[index2]
                        )]
                    )
                ) { //이때 이미 맵에 user의 친구와 친구 상태인 사람이 있다면
                    val string = friends[index][1 - friends[index].indexOf(friendsOfUser[index2])]
                    recommendScore[string] = recommendScore[string]?.plus(10)!! // value에 10을 더해줌
                } else { // 맵에 key로는 user의 친구와 친구 상태인 사람으로, value는 10으로 저장
                    recommendScore[friends[index][1 - friends[index].indexOf(friendsOfUser[index2])]] =
                        10
                }
            }
        }
    }
}

/**
 * 기존 점수에 방문자 점수도 추가하는 함수
 */
fun addScoreByVisit(visitors: List<String>, friendsOfUser: ArrayList<String>, recommendScore: MutableMap<String, Int>){
    for (index in visitors.indices){ //
        if (friendsOfUser.contains(visitors[index])) continue // 이미 친구인 사람은 제외
        if (recommendScore.containsKey(visitors[index])){
            recommendScore[visitors[index]] = recommendScore[visitors[index]]?.plus(1)!!
        }
        else{
            recommendScore[visitors[index]] = 1
        }
    }
}

/**
 * 점수가 같을 때 이름 순으로 정렬해주는 함수
 */
fun sortWithName(result: ArrayList<String>, recommendScore: MutableMap<String, Int>){
    val recommendScoreInList = recommendScore.toList().sortedByDescending { it.second } // 점수 순으로 정렬하여 list로 만듦

    for (index in recommendScoreInList.indices) {
        val tempArray = ArrayList<String>() //tempArray는 반복문이 돌 때마다 초기화
        for ((key,value) in recommendScore) { // 맵의 개수만큼 반복문을 돌려
            if (value == recommendScoreInList[index].second){ // value값이 같은 요소의 key를 tempArray에 저장
                tempArray.add(key)
            }
        }
        result += result + tempArray.sorted() //result에 오름차순으로 정렬된 배열들을 계속해서 더함
    }
}

/**
 * 5명 순으로 짜른 배열을 생성
 */
fun divideIntoFive(array: List<String>): ArrayList<String>{
    val finalResult = ArrayList<String>()
    for (index in array.indices){
        if (index > 4) break
        finalResult.add(array[index])
    }
    return finalResult
}
