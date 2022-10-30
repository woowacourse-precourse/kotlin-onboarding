package onboarding

fun solution7(
  user: String,
  friends: List<List<String>>,
  visitors: List<String>
): List<String> {
  val recommendFriends: List<String>
  val idMap = mutableMapOf<String, MutableList<String>>()
  val scoreMap = mutableMapOf<String, Int>()

  checkSNS(user, friends, visitors)

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

  recommendFriends = scoreMap.toList().sortedByDescending { it.second }.map { it.first }.take(5)

  return recommendFriends
}

fun checkSNS(
  user: String,
  friends: List<List<String>>,
  visitors: List<String>
) {
  val regex = "^[a-z]*\$".toRegex()

  if (user.length !in 1..30) {
    throw IllegalArgumentException(
      "user 아이디는 길이가 1 이상 30 이하인 문자열이어야 합니다."
    )
  }
  friends.forEach { friend ->
    if (friend[0].length !in 1..30 && friend[1].length !in 1..30) {
      throw IllegalArgumentException(
        "friends 리스트의 아이디는 길이가 1 이상 30 이하인 문자열이어야 합니다."
      )
    }
  }
  visitors.forEach { visitor ->
    if (visitor.length !in 1..30) {
      throw IllegalArgumentException(
        "visitors 리스트의 아이디는 길이가 1 이상 30 이하인 문자열이어야 합니다."
      )
    }
  }

  if (friends.size !in 1..10000) {
    throw IllegalArgumentException(
      "friends는 길이가 1 이상 10,000 이하인 리스트/배열이어야 합니다."
    )
  }
  if (visitors.size !in 0..10000) {
    throw IllegalArgumentException(
      "visitors는 길이가 0 이상 10,000 이하인 리스트/배열이어야 합니다."
    )
  }

  if (!user.matches(regex)) {
    throw IllegalArgumentException(
      "user 아이디는 알파벳 소문자만 가능합니다."
    )
  }
  friends.forEach { friend ->
    if (!friend[0].matches(regex) && !friend[1].matches(regex)) {
      throw IllegalArgumentException(
        "friends 리스트의 아이디는 알파벳 소문자만 가능합니다."
      )
    }
  }
  visitors.forEach { visitor ->
    if (!visitor.matches(regex)) {
      throw IllegalArgumentException(
        "visitors 리스트의 아이디는 알파벳 소문자만 가능합니다."
      )
    }
  }
}
