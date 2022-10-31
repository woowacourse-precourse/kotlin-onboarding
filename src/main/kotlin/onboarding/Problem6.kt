package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun getSubWordsOfName(name: String): List<String> {
    var list = arrayListOf<String>()

    for(i in 0 until name.length-1) {
        list.add(name.substring(i..i+1))
    }

    return list
}
