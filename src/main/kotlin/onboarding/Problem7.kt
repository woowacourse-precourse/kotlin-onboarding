package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var answer = arrayListOf<String>()
    var friend = HashMap<String, ArrayList<String>>()
    var score = HashMap<String, Int>()

    for (i in 0..friends.size-1) {
        if (!friend.containsKey(friends[i][0])) {
            var a = arrayListOf<String>(friends[i][1])
            friend.put(friends[i][0], a)
            score.put(friends[i][0], 0)
        } else {
            var a = friend.get(friends[i][0])
            a!!.add(friends[i][1])
            friend.replace(friends[i][0], a)

        }
        if (!friend.containsKey(friends[i][1])) {
            var a = arrayListOf<String>(friends[i][0])
            friend.put(friends[i][1], a)
            score.put(friends[i][1], 0)
        } else {
            var a = friend.get(friends[i][1])
            a!!.add(friends[i][0])
            friend.replace(friends[i][1], a)
        }
    }

    for (i in 0..visitors.size-1) {
        val f = visitors[i]
        if (!friend.containsKey(f)) {
            score.put(f, 1)
        } else {
            var sc = score.get(f)!!.toInt()
            score.replace(f, sc+1)
        }
    }
    if (friend.containsKey(user)) {
        var user_friend = friend.get(user)
        for ((key, value) in score) {
            var next_value = value
            if (friend.containsKey(key)) {
                var x = friend.get(key)
                for (i in 0..user_friend!!.size-1) {
                    if (x!!.contains(user_friend[i])) {
                        next_value += 10
                    }
                }
            }
            score.replace(key, next_value)
        }
    }
    val sortedscore = score.toSortedMap()
    var sortscore = sortedscore.toList().sortedByDescending { it.second }

    var i = 0
    while (i<sortscore.size-1) {
        if (friend.containsKey(user)) {
            var f = friend.get(user)
            if (!f!!.contains(sortscore[i].first) && sortscore[i].first!=user) {
                answer.add(sortscore[i].first)
            }
        }
        i++
    }

    return answer.toList()
}
