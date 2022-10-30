package onboarding

import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
    val friend = HashSet<String>()
}

fun exception7(user : String, friends: List<List<String>>, visitors: List<String>) {
    if(user.length < 1 || user.length > 30) {
        throw IllegalArgumentException("user는 길이가 1이상 30이하여야 합니다.")
    }

    if(friends.size < 1 || friends.size > 10000) {
        throw IllegalArgumentException("friends의 길이는 1이상 10000이하여야 합니다.")
    }

    if(visitors.size < 0 || visitors.size > 10000) {
        throw IllegalArgumentException("visitors의 길이는 0이상 10000이하여야 합니다.")
    }
}

fun exception_id(id : String) {

    if(id.length < 1 || id.length > 30) {
        throw IllegalArgumentException("아이디의 길이는 1이상 30이하여야 합니다.")
    }

    if(!id.matches("^[a-z]*S".toRegex())) {
        throw IllegalArgumentException("아이디는 소문자여야 합니다.")
    }
}

fun connectEdge(friends: List<List<String>>) : LinkedHashMap<String, LinkedList<String>> {

    val graph = LinkedHashMap<String, LinkedList<String>>()

    friends.forEach {
        graph.run {
            set(it[0], LinkedList())
            set(it[1], LinkedList())
        }
    }

    friends.forEach {
        graph.get(it[0])?.add(it[1])
        graph.get(it[1])?.add(it[0])
    }
    return graph
}

fun get_friend(user : String ,friends: List<List<String>>) : Set<String> {

    val graph = connectEdge(friends)
    println(graph.toString())

    return graph.get(user)!!.toSet()
}

fun get_nearFriend(user : String , friends: List<List<String>>, friendList : Set<String>) : Set<String> {

    val near_friend = HashSet<String>()

    val graph = connectEdge(friends)

    friendList.forEach {
        val list = graph.get(it)

        list!!.forEach {

        if(!it.equals(user))
            near_friend.add(it)
        }
    }

    return near_friend
}

fun score_friends(user: String, friends: List<List<String>>, visitors: List<String>) {

    val scoreMap = HashMap<String, Int>()
    val friendList = get_friend(user, friends)
    val near_friendList = get_nearFriend(user, friends, friendList)

    near_friendList.forEach {
        scoreMap.put(it, scoreMap.getOrDefault(it, 0) + 10)
    }
}