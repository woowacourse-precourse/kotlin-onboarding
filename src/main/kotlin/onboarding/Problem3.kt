package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun isContained(x: Int): Boolean {
    return x.toString().contains(Regex("[369]"))
}

fun count(x: Int): Int {
    return Regex("[369]").findAll(x.toString()).count()
}