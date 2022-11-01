package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var userFriendsList = findUserFriends(user, friends)// user와 친구인 이름 목록
    var friendsFriendsList = findFriendsFriends(user, userFriendsList, friends) // user의 친구들과 친구인 이름 목록
    var visitorList = deleteFriendFromVisitor(friendsFriendsList, visitors)

    var result = setPoint(friendsFriendsList, visitors)
    var sorted = result.toList().sortedWith(compareBy { it.first })
    sorted = sorted.sortedWith(compareByDescending { it.second })

    var answer = mutableListOf<String>()
    for(i in sorted.indices){
        answer.add(sorted[i].first)
    }
    return answer
}

/* user와 친구인 이름을 찾는 메소드 */
fun findUserFriends(user: String, friends: List<List<String>>): ArrayList<String> {
    var userFriendsList = arrayListOf<String>()

    for(i in friends.indices){
        if(friends[i][0] == user){
            userFriendsList.add(friends[i][1])
            continue
        }
        if(friends[i][1] == user){
            userFriendsList.add(friends[i][0])
            continue
        }
    }
    return userFriendsList
}

/* user의 친구와 친구인 이름을 찾는 메소드 */
fun findFriendsFriends(user: String, userFriendsList: ArrayList<String>, friends: List<List<String>>): ArrayList<String> {
    var friendsFriendsList = arrayListOf<String>()

    for(name in userFriendsList){
        for(i in friends.indices){
            if(friends[i][0] == name && friends[i][1] != user){
                friendsFriendsList.add(friends[i][1])
                continue
            }
            if(friends[i][1] == name && friends[i][0] != user){
                friendsFriendsList.add(friends[i][0])
            }
        }
    }
    return friendsFriendsList
}

fun deleteFriendFromVisitor(friendsList: ArrayList<String>, visitors: List<String>): MutableList<String>{
    var visitorList = mutableListOf<String>()
    for(i in visitors.indices){
        visitorList.add(visitors[i])
    }
    for(name in friendsList){
        if(visitorList.contains(name)){
            visitorList.removeAt(visitorList.indexOf(name))
        }
    }
    return visitorList
}

fun setPoint(friendsList: ArrayList<String>, visitorList: List<String>): MutableMap<String, Int>{
    var result = mutableMapOf<String, Int>()
    // 친구 목록 확인
    for(i in friendsList){
        var is_contain: Boolean = false
        for(j in result){
            // 이미 result에 해당 이름이 존재하는 경우
            if(j.key == i){
                j.setValue(j.value+10)
                is_contain = true
            }
        }
        // result에 해당 이름이 존재하지 않는 경우
        if(!is_contain){
            result[i] = 10
        }
    }

    // 방문자 목록 확인
    for(i in visitorList){
        var is_contain: Boolean = false
        for(j in result){
            // 이미 result에 해당 이름이 존재하는 경우
            if(j.key == i){
                j.setValue(j.value + 1)
                is_contain = true
            }
        }
        if(!is_contain){
            result[i] = 1
        }
    }

    return result
}



