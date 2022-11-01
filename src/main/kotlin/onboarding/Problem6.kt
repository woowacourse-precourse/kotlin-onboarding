package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val subWordsList = getSubWordsList(forms)
    var resultList = arrayListOf<String>()

    for(i in forms.indices) {
        if(isDuplicatedName(i, subWordsList)) {
            resultList.add(forms[i][0])
        }
    }

    resultList.sort()
    return resultList
}

fun isDuplicatedName(index: Int, subWordsList: Array<HashSet<String>>): Boolean {
    for(i in subWordsList.indices) {
        if(index == i) {
            continue
        }

        if(subWordsList[index].any { subWordsList[i].contains(it) }) {
            return true
        }
    }

    return false
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
