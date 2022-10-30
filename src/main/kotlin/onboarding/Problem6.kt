package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun convertNickNameToTwoLetterSet(nickNmae: String): Set<String> {
    val twoLetterSet = hashSetOf<String>()
    for (i in 0 until nickNmae.length - 1) {
        twoLetterSet.add(nickNmae.substring(i, i + 2))
    }
    return twoLetterSet
}




