package onboarding

//기능별 목록
//1. 이미 친구인 목록 추출 함수
//2. 추천친구 가능한 친구 목록 추출 함수
//3. 추출친구의 친구인 목록 추출 함수
//4. map을 통해 점수를 계산하고 정렬하는 함수
//5. map에서 key를 추출하는 함수

fun solution7(
        user: String,
        friends: List<List<String>>,
        visitors: List<String>
): List<String> {
    val friendslist = alredayfriends(friends, user)
    val friendsfriendlist = friendsfriend(friends, friendslist)
    val possiblefriendslist = possiblerecommend(friends, visitors, friendslist, user)
    return possiblefriendslist
}

//이미 친구인 목록 추출 함수
fun alredayfriends(friends: List<List<String>>, user: String): List<String> {
    var friendslist: MutableList<String> = mutableListOf()
    for (i: Int in friends.indices) {
        if (friends[i][1] == user) {
            friendslist.add(friends[i][0])
        }
    }

    friendslist = friendslist.distinct().toMutableList()
    println(friendslist)
    return friendslist
}

//친구의 친구인 목록 추출 함수
fun friendsfriend(friends: List<List<String>>, friendslist: List<String>): List<String> {
    var friendsfriendlist: MutableList<String> = mutableListOf()
    for (i: Int in friends.indices) {
        if (friendslist.contains(friends[i][0])) {
            friendsfriendlist.add(friends[i][1])
        }
    }
    friendsfriendlist = friendsfriendlist.distinct().toMutableList()
    println(friendsfriendlist)
    return friendsfriendlist
}

//추천친구 가능한 친구 목록 추출 함수
fun possiblerecommend(friends: List<List<String>>, visitors: List<String>, friendslist: List<String>, user: String): List<String> {
    val possiblefriends: MutableList<String> = mutableListOf()
    for (i: Int in friends.indices) {
        for (j: Int in friendslist.indices) {
            if (friends[i][0] == friendslist[j] && friends[i][1] != user) {
                possiblefriends.add(friends[i][1])
            }
        }
    }
    for (i in visitors) {
        if (!friendslist.contains(i))
            possiblefriends.add(i)
    }
    println(possiblefriends)
    return possiblefriends
}
