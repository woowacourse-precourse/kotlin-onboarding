package onboarding

//기능 목록
/*
     1. friends에서 user의 친구를 확인한다.
     2. 1.에서 확인된 친구들의 친구를 friends에서 확인한다.
     3. 2.에서 확인된 친구의 친구는 10점 부여한다.
     4. visitors에서 user의 친구가 아닌 사람들을 확인한다.
     5. 4.에서 확인된 사람들은 1점 부여한다.
 */

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    //프로그램 구현

//    1. friends에서 user의 친구를 확인한다.
    val userFriends = checkFriends(user, friends)


    var friendsFriendsResult = friendsFriends(user, userFriends, friends)
    var visitorsResult = checkVisitors(userFriends, visitors)
    var result = mutableMapOf<String, Int>()

    for(i in 0 until friendsFriendsResult.indices){
        if(friendsFriendsResult[i][0] == visitorsResult[i][0])
            result[friendsFriendsResult[i][0]] = (friendsFriendsResult[i][1] + visitorsResult[i][1])
    }

    return result.filter{ it.value > 0}.toList().sortedWith(comparator).map{it.first}

}

fun checkFriends(user: String, friends: List<List<String>>): List<String>{

    val userFriends = mutablListOf<String>()
    //1. friends에서 user의 친구를 확인한다.
    for(i in friends){
        if(i[0] == user) userFriends.add(i[1])
        if(i[1] == user) userFriends.add(i[0])
    }
    return userFriends
}

fun friendsFriends(user: String, userFriends : List<String>, friends: List<List<String>>): MutableList<String, Int>{

    var scoreList = mutableMapOf<String, Int>()
    //2. 1.에서 확인된 친구들의 친구를 friends에서 확인한다.
    //3. 2.에서 확인된 친구의 친구는 10점 부여한다.
    for(i in friends){
        if(friends.contains(i[0]) && !i.contains(user)){
            scoreList[i[1]] += 10
        }
        if(friends.contains(i[1]) && !i.contains(user)){
            scoreList[i[0]] += 10
        }
    }
    return scoreList
}

fun checkVisitors(userFriends: List<String>, visitors: List<String>): MutableList<String, Int>{

    var scoreList = mutableMapOf<String, Int>()
//    4. visitors에서 user의 친구가 아닌 사람들을 확인한다.
//    5. 4.에서 확인된 사람들은 1점 부여한다.
    for(i in visitors){
        if(!userFriends.contains(i))
            scoreList[i] += 1
    }
    return scoreList
}