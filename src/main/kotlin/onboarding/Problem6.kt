package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun getSubWordsList(forms: List<List<String>>): Array<HashSet<String>> {
    var lists = Array(forms.size) { HashSet<String>() }

    for(i in forms.indices) {
        lists[i] = getSubWordsOfName(forms[i][1])
    }

    return lists
}

fun getSubWordsOfName(name: String): HashSet<String> {
    var list = HashSet<String>()

    for(i in 0 until name.length-1) {
        list.add(name.substring(i..i+1))
    }

    return list
}
