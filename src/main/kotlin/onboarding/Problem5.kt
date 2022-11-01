package onboarding

fun solution5(money: Int): List<Int> {
    val money = money

    if(isCorrect5(money)) {

    }
    else return listOf(-1)
}

fun isCorrect5(money: Int): Boolean {
    val condition1 = money in 1..1000000
    return condition1
}
