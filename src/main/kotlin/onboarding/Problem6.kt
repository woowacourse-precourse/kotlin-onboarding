package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}


fun splitTwoLength(userName : String): ArrayList<String> {
    val splitResult = arrayListOf<String>()
    for (i in 0 until userName.lastIndex) {
        splitResult.add(userName.substring(i,i+2))
    }

    return splitResult
}


