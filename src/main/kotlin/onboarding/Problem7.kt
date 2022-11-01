package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var user_friends= mutableSetOf<String>()
    for(i in 0..friends.size-1){
        if(friends[i][0]==user) user_friends.add(friends[i][1])
        if(friends[i][1]==user) user_friends.add(friends[i][0])
    }

    var count = mutableMapOf<String, Int>()
    for(i in 0..friends.size-1){
        if(user_friends.contains(friends[i][0])){
            if(friends[i][1]==user) continue
            var rcmd=friends[i][1]
            count[rcmd]=count.getOrDefault(rcmd, 0)+10
        }
        if(user_friends.contains(friends[i][1])){
            if(friends[i][0]==user) continue
            var rcmd=friends[i][0]
            count[rcmd]=count.getOrDefault(rcmd, 0)+10
        }
    }

    for(i in 0..visitors.size-1){
        var rcmd=visitors[i]
        if(user_friends.contains(rcmd)) continue
        count[rcmd]=count.getOrDefault(rcmd, 0)+1
    }

    var to_list=count.toList()
    var sorted = to_list.sortedWith(compareByDescending<Pair<String, Int>> {it.second}.thenBy { it.first })
    var answer= mutableListOf<String>()
    for(i in 0..sorted.size-1){
        if(answer.size<5) answer.add(sorted[i].first)
    }

    return answer
}
