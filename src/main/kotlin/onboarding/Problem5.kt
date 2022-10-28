package onboarding

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
fun convertMoney(x: Int, moneyList: List<Int>): List<Int> {

    val result = MutableList<Int>(9) { 0 }
    var target = x

    for ((index, money) in moneyList.withIndex()) {
        if (target == 0) break
        val mok = target / money
        result[index] = mok
        target -= mok * money
    }
    return result
}
