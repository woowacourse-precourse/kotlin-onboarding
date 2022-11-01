package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun splitByTwo(nickname: String): MutableList<String> {
    val result = mutableListOf<String>()

    for(i in 0 until nickname.length - 1) {
        result.add(nickname.substring(i, i + 1))
    }

    return result
}