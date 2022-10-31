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
    fun scoreSet(): HashMap<String, Int> {
        var scoreSet = HashMap<String, Int>()
        for (i in 0..friends.size - 1) {
            scoreSet.put(friends[i][0], 0)
            scoreSet.put(friends[i][1], 0)

        }
        for (i in 0..visitors.size - 1) {
            if (!scoreSet.containsKey(visitors[i])) {
                scoreSet.put(visitors[i], 0)
            }
        }
        for (i in 0..myFriends.size - 1) {
            scoreSet.remove(myFriends[i])
        }
        scoreSet.remove(user)
        return scoreSet
    }
    myFriends = findMyFriends(friends)
    score = scoreSet()

    //친구의 친구 점수 증가
    fun acquaintance(friends: List<List<String>>): Unit {
        for (i in 0..friends.size - 1) {
            for (j in 0..myFriends.size - 1) {
                if (friends[i][0].equals(myFriends[j])) {
                    if (score.containsKey(friends[i][1])) {
                        score.replace(friends[i][1], score.get(friends[i][1]) as Int + 10)
                    }
                }
                if (score.containsKey(friends[i][1])) {
                    if (friends[i][1].equals(myFriends[j])) {
                        score.replace(friends[i][0], score.get(friends[i][0]) as Int + 10)
                    }
                }
            }
        }
    }
    acquaintance(friends)
    //방문자 점수 증가
    fun visitorScore(): Unit {
        for (i in 0..visitors.size - 1) {
            if (score.containsKey(visitors[i])) {
                score.replace(visitors[i], score.get(visitors[i]) as Int + 1)
            }
        }
    }
    visitorScore()
    return result
}
