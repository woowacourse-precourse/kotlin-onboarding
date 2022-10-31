package onboarding

fun solution6(forms: List<List<String>>): List<String> 
{
    //TODO("프로그램 구현")
    var dict = mutableMapOf<String, String>()
    var ret = mutableSetOf<String>()

    forms.forEach{crew ->
        dict.forEach { (key,value) ->
            if (checkdup(crew[1], key))
            {
                ret.addAll(listOf(crew[0],value))
            }
        }
        dict[crew[1]] = crew[0]
    }
    ret = ret.toSortedSet()
    return ret.toList()
}

fun checkdup(str1: String, str2: String): Boolean {
    for (i in 0 until str1.length - 1) {
        if (str2.contains(str1.substring(i, i + 2))) {
            return true
        }
    }
    return false
}