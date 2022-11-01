package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableListOf<String>()
    val crewInfoMap = mutableMapOf<String, String>()
    var nicknameSet = mutableSetOf<String>()

    forms.forEach { crewInfo ->
        nicknameSet = getDuplicatedNicknames(crewInfo[1], crewInfoMap, nicknameSet)
        crewInfoMap[crewInfo[0]] = crewInfo[1]
    }

    nicknameSet.forEach { nickname ->
        result.addAll(getEmailByNickname(nickname, crewInfoMap))
    }
    result.sort()

    return result.toList()
}

private fun getDuplicatedNicknames(
    nickname: String,
    crewInfoMap: MutableMap<String, String>,
    nicknameSet: MutableSet<String>
): MutableSet<String> {
    crewInfoMap.values.forEach { crewNickname ->
        if (checkDuplicated(nickname, crewNickname)) {
            nicknameSet.add(nickname)
            nicknameSet.add(crewNickname)
        }
    }
    return nicknameSet
}

private fun checkDuplicated(nickname1: String, nickname2: String): Boolean {
    for (i in 0 until nickname1.length - 1) {
        if (nickname2.contains(nickname1.substring(i, i + 2))) {
            return true
        }
    }
    return false
}

private fun getEmailByNickname(nickname: String, crewInfoMap: MutableMap<String, String>): List<String> {
    return crewInfoMap.filterValues { it == nickname }
        .keys
        .toList()
}