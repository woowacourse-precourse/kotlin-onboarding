package onboarding

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendList = addFriendRelation(friends, visitors)
    val score = initialScore(friendList)

    addScore(friendList, score, visitors, user)

    return recommendList(friendList, score, user)
}

fun addFriendRelation(friends: List<List<String>>, visitors: List<String>): HashMap<String, ArrayList<String>> {
    val friendList = HashMap<String, ArrayList<String>>()
    var list: ArrayList<String>

    friends.forEach {
        if(!friendList.containsKey(it[0])) friendList[it[0]] = arrayListOf(it[1])
        else {
            list = friendList[it[0]]!!
            list.add(it[1])
            friendList[it[0]] = list
        }

        if(!friendList.containsKey(it[1])) friendList[it[1]] = arrayListOf(it[0])
        else {
            list = friendList[it[1]]!!
            list.add(it[0])
            friendList[it[1]] = list
        }
    }

    visitors.forEach {
        if(!friendList.containsKey(it)) friendList[it] = arrayListOf()
    }

    return friendList
}

fun initialScore(friendList: HashMap<String, ArrayList<String>>): HashMap<String, Int> {
    val keys = friendList.keys.toList()
    val nameList = HashMap<String, Int>()

    keys.forEach {
        nameList[it] = 0
    }

    return nameList
}

fun bothFriendCnt(friendList: HashMap<String, ArrayList<String>>, user: String, other: String): Int {
    val userFriendList = friendList[user]
    val otherFriendList = friendList[other]
    var cnt = 0

    otherFriendList?.forEach {
        if(userFriendList!!.contains(it)) cnt++
    }

    return cnt
}

fun addScore(friendList:HashMap<String, ArrayList<String>>, score: HashMap<String, Int>, visitors: List<String>, user: String) {
    score.forEach {
        val name = it.key
        if(name == user) return@forEach
        score[name] = bothFriendCnt(friendList, user, name) * 10
    }

    visitors.forEach {
        score[it] = score[it]!!.plus(1)
    }
}

fun recommendList(friendList: HashMap<String, ArrayList<String>>, score: HashMap<String, Int>, user: String): ArrayList<String> {
    val sortedScore = score.toList().sortedWith(compareBy({-(it.second)}, {it.first})).toMap() as MutableMap
    val list = ArrayList<String>()
    sortedScore.forEach {
        if(it.value == 0) return@forEach
        if(friendList[user]!!.contains(it.key)) return@forEach
        list.add(it.key)
    }

    return list
}