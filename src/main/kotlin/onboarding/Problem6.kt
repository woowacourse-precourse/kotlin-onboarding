package onboarding

class User(val email: String, val nickname: String)

val nickNameMap = HashMap<String, ArrayList<User>>()
val resultKey = ArrayList<String>()
fun solution6(forms: List<List<String>>): List<String> {
    for(elem in forms) {
        val divList = dividedList(elem[1])
        updateNicknameMap(User(email = elem[0], nickname = elem[1]), divList)
    }

    var result = resultHashSet().toSortedSet()
    return result.toList()
}

fun dividedList(string: String): List<String> {
    val resultList = ArrayList<String>()

    for (i in 0 until string.length - 1) {
        resultList.add(string.substring(i, i + 2))
    }

    return resultList
}

fun updateNicknameMap(user: User, divList: List<String>) {
    for (word in divList) {
        if (nickNameMap.containsKey(word)) {
            if(nickNameMap[word]!!.size == 1)
                resultKey.add(word)
        } else {
            nickNameMap[word] = ArrayList()
        }
        nickNameMap[word]!!.add(user)
    }
}

fun resultHashSet(): HashSet<String> {
    val result = HashSet<String>()
    for(key in resultKey) {
        for(user in nickNameMap[key]!!) {
            result.add(user.email)
        }
    }
    return result
}
