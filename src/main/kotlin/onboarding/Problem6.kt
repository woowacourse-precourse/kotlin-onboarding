package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableListOf<String>()
    val crewInfoMap = mutableMapOf<String, String>()
    val nicknameSet = mutableSetOf<String>()

    forms.forEach { crewInfo ->
        crewInfoMap.keys.forEach { nickname ->
            if (checkDuplicated(crewInfo[1], nickname)) {
                nicknameSet.add(nickname)
                nicknameSet.add(crewInfo[1])
            }
        }
        crewInfoMap[crewInfo[1]] = crewInfo[0]
    }

    result.run {
        addAll(nicknameSet.mapNotNull { nickname -> crewInfoMap[nickname] })
        sort()
    }

    return result.toList()
}

private fun checkDuplicated(nickname1: String, nickname2: String): Boolean {
    for (i in 0 until nickname1.length - 1) {
        if (nickname2.contains(nickname1.substring(i, i + 2))) {
            return true
        }
    }
    return false
}