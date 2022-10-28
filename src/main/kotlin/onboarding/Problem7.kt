package onboarding

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1. friends 배열을 바탕으로 관계를 hashmap으로 만들어준다.
2. 함께 아는 친구의 수에 따라 점수를 계산한다.
3. 타임 라인에 방문한 횟수에 따라 점수를 계산한다.
4. 점수를 내림차순 정렬하고 최대 5명을 리턴한다.
 */

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // 1. friends 배열을 바탕으로 관계를 hashmap으로 만들어준다.
    val hm = makeRelations(friends)

    // 2. 함께 아는 친구의 수에 따라 점수를 계산한다.
    var score: MutableMap<String, Int> = calcFriendPoint(hm, user)

    // 3. 타임 라인에 방문한 횟수에 따라 점수를 계산한다.
    calcVisitorsPoint(visitors, hm, user, score)

    // 4. 점수를 내림차순 정렬하고 최대 5명을 리턴한다.
    return makeResult(score)
}

// 1. friends 배열을 바탕으로 관계를 hashmap으로 만들어준다.
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

// 2. 함께 아는 친구의 수에 따라 점수를 계산한다.
private fun calcFriendPoint(hm: HashMap<String, ArrayList<String>>, user: String): MutableMap<String, Int> {
    var score: MutableMap<String, Int> = TreeMap()

    for (key in hm.keys) {
        if (key == user) {
            continue
        } else {
            for (i in 0 until hm.get(user)!!.size) {
                if (hm[key]!!.contains(hm[user]!![i])) {
                    score[key] = score.getOrDefault(key, 0) + 10
                }
            }
        }
    }
    return score
}

// 3. 타임 라인에 방문한 횟수에 따라 점수를 계산한다.
private fun calcVisitorsPoint(visitors: List<String>, hm: HashMap<String, ArrayList<String>>, user: String, score: MutableMap<String, Int>) {
    for (i in visitors.indices) {
        if (!hm[user]!!.contains(visitors[i])) {
            score[visitors[i]] = score.getOrDefault(visitors[i], 0) + 1
        }
    }
}

// 4. 점수를 내림차순 정렬하고 최대 5명을 리턴한다.
private fun makeResult(score: MutableMap<String, Int>): List<String> {
    var score1 = score
    score1 = score1.toList().sortedByDescending { it.second }.toMap() as MutableMap

    val res = ArrayList<String>()
    var idx = 0
    for (key in score1.keys) {
        if(idx == 5){
            break
        }
        res.add(key)
        idx++
    }

    return res.toList()
}