package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    validateId(user)
    validateFriends(friends)
    validateVisitors(visitors)

    val priorities = mutableMapOf<String, Int>()
    friends.forEach { relationship -> relationship.forEach { priorities[it] = 0 } }
    visitors.forEach { priorities[it] = 0 }

    val relationships = getRelationships(priorities.keys, friends)
    relationships[user]!!.forEach {
        relationships[it]!!.forEach { acquaintance ->
            priorities[acquaintance] = priorities[acquaintance]!! + 10
        }
    }

    visitors.forEach { priorities[it] = priorities[it]!! + 1 }

    val result = priorities.entries.sortedWith(compareBy({ -it.value }, { it.key }))
        .filter { it.value > 0 && it.key != user && !relationships[user]!!.contains(it.key) }
        .map { it.key }

    if (result.size > 5)
        return result.subList(0, 5)
    return result
}

fun getRelationships(ids: Set<String>, friends: List<List<String>>): Map<String, Set<String>> {
    val relationships = mutableMapOf<String, HashSet<String>>()
    ids.forEach { relationships[it] = hashSetOf() }

    friends.forEach {
        relationships[it[0]]!!.add(it[1])
        relationships[it[1]]!!.add(it[0])
    }

    return relationships
}

fun validateVisitors(visitors: List<String>) {
    if (visitors.size !in 0..10_000)
        throw IllegalArgumentException("방문자는 0명 이상 10,000명 이하여야 합니다.")
}

fun validateFriends(friends: List<List<String>>) {
    if (friends.size !in 1..10_000)
        throw IllegalArgumentException("친구 관계 정보는 1 이상 10,000 이하여야 합니다.")
    if (friends.any { it.size != 2 })
        throw IllegalArgumentException("친구 관계 정보는 길이가 2여야 합니다.")
    if (friends.distinct().size != friends.size)
        throw IllegalArgumentException("동일한 친구 관계가 중복해서 주어지지 않아야 합니다.")
    friends.forEach { it.forEach { id -> validateId(id) } }
}

fun validateId(id: String) {
    if (id.length !in 1..30 || !id.any { it.isLowerCase() })
        throw IllegalArgumentException("아이디는 길이가 1 이상 30 이하이고 알파벳 소문자로 이루어져야 합니다.")
}
