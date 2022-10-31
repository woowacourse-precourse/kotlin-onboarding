package onboarding

import java.util.stream.Collectors.toList

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val scoreMap = mutableMapOf<String, Int>()
    val friendMap = mutableMapOf<String, MutableList<String>>()

    friends.map{
        if(friendMap[it[0]] == null){
            friendMap[it[0]] = mutableListOf()
        }
        friendMap[it[0]]!!.add(it[1])

        if(friendMap[it[1]] == null){
            friendMap[it[1]] = mutableListOf()
        }
        friendMap[it[1]]!!.add(it[0])

    }

    friendMap[user]?.map{ f ->
        friendMap[f]?.map{
            if(!scoreMap.containsKey(it)){
                scoreMap[it] = 0
            }
            scoreMap[it] = scoreMap[it]!! + 10
        }

    }


    visitors.map{
        if(!scoreMap.containsKey(it)){
            scoreMap[it] = 0
        }
        scoreMap[it] = scoreMap[it]!! + 1
    }

    scoreMap[user] = -100
    friendMap[user]?.map{
        scoreMap[it] = -100
    }

    val comparator : Comparator<Pair<String, Int>> = compareByDescending<Pair<String, Int>> {it.second}.thenBy { it.first }


    return scoreMap.filter{ it.value > 0}.toList().sortedWith(comparator).map{it.first}
}



fun main() {
    val user = "mrko"

    val a: MutableList<List<String>> = mutableListOf()
    a.add(listOf("donut", "andole"))
    a.add(listOf("donut", "jun"))
    a.add(listOf("donut", "mrko"))
    a.add(listOf("shakevan", "andole"))
    a.add(listOf("shakevan", "jun"))
    a.add(listOf("shakevan", "mrko"))

    val b = listOf<String>("bedi", "bedi", "donut", "bedi", "shakevan")

    println(solution7(user, a, b))

}