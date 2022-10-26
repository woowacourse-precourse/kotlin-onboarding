package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val overlapUserEmail = mutableSetOf<String>()
    // 2글자씩 포함된 원소가 있는지 비교하는 기능
    forms.forEach { current ->
        val strs = getStrList(current[1])
        strs.forEach { str ->
            overlapUserEmail.addAll(getEmail(forms, current, str))
        }
    }
    // 출력하는 기능
    return overlapUserEmail.toList().sorted()
}

// 비교해야할 문자 만드는 기능
private fun String.getStr(index: Int) = "${this[index - 1]}${this[index]}"

// 비교해야할 문자 만드는 기능
private fun getStrList(name: String): List<String> {
    val list = mutableListOf<String>()
    for (i in 1 until name.length) {
        list.add(name.getStr(i))
    }
    return list
}

// 2글자씩 포함된 원소가 있는지 비교하는 기능
private fun getEmail(
    users: List<List<String>>,
    current: List<String>,
    str: String
): Set<String> {
    val set = mutableSetOf<String>()
    users.forEach { user ->
        if (current != user && str in user[1]) {
            set.add(current[0])
            set.add(user[0])
        }
    }
    return set
}

fun main() {

}
