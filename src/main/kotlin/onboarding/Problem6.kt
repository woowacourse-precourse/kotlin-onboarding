package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val set = mutableSetOf<String>()
    forms.forEachIndexed { listIndex, list ->
        val name = list[1]
        for (idx in 0..name.length - 2) {
            val subName = name.substring(idx, idx + 2)
            set.addAll(containsCheckSubName(forms, listIndex, subName))
        }
    }

    return set.toMutableList().sorted()
}

fun containsCheckSubName(forms: List<List<String>>, listIndex: Int, subName: String): MutableSet<String> {
    val crewNameList = mutableSetOf<String>()
    forms.forEachIndexed { index, info ->
        if (info[1].contains(subName) && index != listIndex) {
            crewNameList.add(info[0])
        }
    }
    return crewNameList
}