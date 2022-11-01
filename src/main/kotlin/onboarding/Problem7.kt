package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val myFriends = mutableListOf<List<String>>()
    val myFriend = mutableListOf<String>()
    var resultScore = mutableMapOf<String, Int>()



    for (i in friends) {   // 내 친구찾기
        if (i.contains(user)) {

            myFriends.add(i)
        }
    }

    for (j in 0 until myFriends.size) { // 내 친구 찾기2
        if (user in myFriends[j]) {

            myFriend.add((myFriends[j] - user)[0])

        }
    }
    //  println(myFriend)

}
