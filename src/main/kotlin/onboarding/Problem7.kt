package onboarding

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")

    var visit = mutableListOf<String>()
    var already_fr = mutableListOf<String>()
    var score : MutableList<Int> = MutableList<Int>(visit.size) {0}
    var answer = mutableMapOf<String,Int>()

    // var visit
    for (i in 0..friends.size-1){
        visit.add(friends[i][0])
        visit.add(friends[i][1])
    }
    for (i in 0..visitors.size-1){
        visit.add(visitors[i])
    }

    // var already_fr
    for(i in 0 .. friends.size-1){
        if (user == friends[i][0])
            already_fr.add(friends[i][1])
        if (user == friends[i][1])
            already_fr.add(friends[i][0])
    }
    visit = visit.distinct().toMutableList()
    visit.remove(user)

    // var score
    for(i in 0..score.size-1){
        score[i] += visitors.count(){it == visit[i]}
    }

    // var answer
    for (i in 0..visit.size-1){
        answer.put(visit[i],score[i])
    }

    for (i in 0..friends.size-1){
        for(j in 0..already_fr.size-1) {
            if (friends[i][0] == already_fr[j] && friends[i][1] != user)
                answer.replace(friends[i][1],answer.getValue(friends[i][1])+10)
            if (friends[i][1] == already_fr[j] && friends[i][0] != user )
                answer.replace(friends[i][0],answer.getValue(friends[i][1])+10)
        }
    }
    answer = answer.toList().sortedByDescending { it.second  }.toMap()as MutableMap<String, Int>

    var result = answer.keys.toList()
    var ans_list = listOf<String>(result[0],result[1],result[2])

    return ans_list.toList()
}