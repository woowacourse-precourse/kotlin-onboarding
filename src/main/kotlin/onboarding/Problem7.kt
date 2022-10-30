package onboarding

fun solution7(
  user: String,
  friends: List<List<String>>,
  visitors: List<String>
): List<String> {
  val recommendFriends: List<String> = listOf("")
  val idMap = mutableMapOf<String, MutableList<String>>()
  val scoreMap = mutableMapOf<String, Int>()

  friends.forEach { friend ->
    val idA = friend[0]
    val idB = friend[1]

    if (idMap.containsKey(idA)) idMap[idA]?.add(idB) else idMap[idA] = mutableListOf(idB)
    if (idMap.containsKey(idB)) idMap[idB]?.add(idA) else idMap[idB] = mutableListOf(idA)
  }

  idMap[user]?.forEach {
    idMap[it]?.filter { it != user }?.forEach { friend ->
      if (scoreMap.containsKey(friend)) scoreMap[friend] = scoreMap.getValue(friend) + 10
      else scoreMap[friend] = 10
    }
  }

  visitors.filter { idMap[user]?.contains(it) == false }.forEach { visitor ->
    if (scoreMap[visitor] != null) scoreMap[visitor] = scoreMap.getValue(visitor) + 1
    else scoreMap[visitor] = 1
  }

  return recommendFriends
}
