package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
//    TODO("프로그램 구현")
    val result= mutableListOf<String>()

    val member = mutableMapOf<String, MutableList<String>>()
    val memberScore = mutableMapOf<String, Int>()
    for (friend in friends){
        if (!member.containsKey(friend[0])){
            member[friend[0]] = mutableListOf<String>()
            memberScore[friend[0]] = 0

        }
        if (!member.containsKey(friend[1])){
            member[friend[1]] = mutableListOf<String>()
            memberScore[friend[1]] = 0
        }
        member[friend[0]]?.add(friend[1])
        member[friend[1]]?.add(friend[0])
    }
    println(member)
    for (m in member.keys){
        if (m == user){
            continue
        }
        for (f in member[m]!!){
            if (member[user]?.contains(f) == true){
                memberScore[m] = memberScore[m]!! + 10
            }
        }
    }

    for (v in visitors){
        if (!memberScore.contains(v)){
            memberScore[v] = 0
        }
        memberScore[v] = memberScore[v]!! + 1
    }

    for (m in memberScore.toList().sortedBy { it.first }.reversed().sortedBy{ it.second}.reversed()){
        if (m.second == 0){
            break
        }
        if (member[user]?.contains(m.first) == false){
            result.add(m.first)
        }
    }

    return result
}


