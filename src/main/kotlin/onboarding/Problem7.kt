package onboarding

/*
1. friends 배열을 바탕으로 관계를 hashmap으로 만들어준다.
2. 함께 아는 친구의 수에 따라 점수를 계산한다.
3. 타임 라인에 방문한 횟수에 따라 점수를 계산한다.
4. 점수를 내림차순 정렬하고 최대 5명을 리턴한다.
*/

import java.util.*
import kotlin.collections.*

fun solution7(
        user: String,
        friends: List<List<String>>,
        visitors: List<String>
): List<String> {

    val hm = makeRelations(friends)

    var score: MutableMap<String, Int> = calcFreindPoint(hm, user)

    calcVisitorsPoint(visitors, hm, user, score)

    return makeResult(score)
}

private fun makeRelations(friends: List<List<String>>): HashMap<String, ArrayList<String>> {
    val hm = HashMap<String, ArrayList<String>>()
    for (i in friends.indices) {
        val list1 = hm.getOrDefault(friends[i][0], arrayListOf())
        val list2 = hm.getOrDefault(friends[i][1], arrayListOf())
        list1.add(friends[i][1])
        list2.add(friends[i][0])
        hm[friends[i][0]] = list1
        hm[friends[i][1]] = list2
    }
    return hm
}

private fun calcFreindPoint(hm: HashMap<String, ArrayList<String>>, user: String): MutableMap<String, Int> {
    var score: MutableMap<String, Int> = TreeMap()

    for (key in hm.keys) {
        if (key == user) {
            continue
        } else if(hm[key]!!.contains(user)){
            score[key] = 0
        } else {
            if(hm[user] != null){
                for (i in 0 until hm[user]!!.size) {
                    if (hm[key]!!.contains(hm[user]!![i])) {
                        score[key] = score.getOrDefault(key, 0) + 10
                    }
                }
            } else {
                score[key] = 0
            }

        }
    }
    return score
}

private fun calcVisitorsPoint(visitors: List<String>, hm: HashMap<String, ArrayList<String>>, user: String, score: MutableMap<String, Int>) {
    for (i in visitors.indices) {
        if(hm[user] != null){
            if (!hm[user]!!.contains(visitors[i])) {
                score[visitors[i]] = score.getOrDefault(visitors[i], 0) + 1
            }
        } else {
            score[visitors[i]] = score.getOrDefault(visitors[i], 0) + 1
        }

    }
}

private fun makeResult(score: MutableMap<String, Int>): List<String> {

    var score1 = score
    score1 = score1.toList().sortedByDescending { it.second }.toMap() as MutableMap

    val res = ArrayList<String>()
    var idx = 0
    for (key in score1.keys) {
        if(idx == 5){
            break
        }
        if(score[key] != 0){
            res.add(key)
            idx++
        }

    }

    return res.toList()
}