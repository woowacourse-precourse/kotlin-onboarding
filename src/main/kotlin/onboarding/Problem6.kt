package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var ret = mutableListOf<String>()
    for (crewIdx in forms.indices)
        for (i in 0 until crewIdx - 1)
            if (checkDup(forms[crewIdx][1], forms[i][1])){
                ret.addAll(listOf(forms[crewIdx][0], forms[i][0]))
                break
            }
    return ret.toSet().toList().sorted()
}

/* 1. Check duplicates when two or more than consecutive elements are the same */
fun checkDup(str1: String, str2: String): Boolean {
    for (i in 0 until str1.length - 1)
        if (str2.contains(str1.substring(i, i + 2)))
            return true
    return false
}