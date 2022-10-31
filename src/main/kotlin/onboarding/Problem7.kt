package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var known = mutableListOf<String>() // 사용자가 이미 아는 친구들
    var recom = mutableListOf<String>()
    var scoreboard = mutableMapOf<String,Int>()
    var unknownvisitors = visitors.toMutableList()

    for(i in friends.indices){
        recom.add(friends[i][0])
        recom.add(friends[i][1])
    }
    for(i in visitors.indices){
        recom.add(visitors[i])
    }
    recom = recom.distinct().toMutableList()
    recom.remove(user)

    var sco = MutableList(recom.size){0} //점수들목록

    for (i in friends.indices){
        if(friends[i][1]==user){
            known.add(friends[i][0])
            for (j in friends.indices){
                if(friends[j][0]==friends[i][0]){
                    for (k in recom.indices){
                        if(recom[k]==friends[j][1]){
                            sco[k]+=10
                        }
                    }
                }
            }
        }
        if(friends[i][0]==user){
            known.add(friends[i][1])
            for (j in friends.indices){
                if(friends[j][1]==friends[i][1]){
                    for (k in recom.indices){
                        if(recom[k]==friends[j][0]){
                            sco[k]+=10
                        }
                    }
                }
            }
        }
    }

    for (i in visitors.indices){
        if(known.contains(visitors[i])) {
            unknownvisitors.remove(visitors[i])
        }
    }

    for (i in unknownvisitors.indices){
        for (j in recom.indices) {
            if (unknownvisitors[i] == recom[j]) {
                sco[j] += 1
            }
        }
    }

    for (i in recom.indices) {
        scoreboard.put(recom[i],sco[i])
    }
    scoreboard = scoreboard.toList().sortedByDescending { it.second }.toMap()as MutableMap<String, Int>
    scoreboard.entries.removeIf { it.value == 0 }
    var resultlist = scoreboard.keys.toList() as MutableList<String>
    if(resultlist.size >= 5)
        return(mutableListOf(resultlist[0],resultlist[1],resultlist[2],resultlist[3],resultlist[4]))
    return resultlist
}
