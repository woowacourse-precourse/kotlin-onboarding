package onboarding

val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

fun solution5(money: Int): List<Int> {
    val result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    return  calculateMoney(0, money, result)
}

fun calculateMoney(index : Int, money : Int, result : MutableList<Int>) : List<Int> {
    if (money == 0) {
        return result
    }
    if (money / moneyList[index] != 0) {
        result[index] = (money / moneyList[index])
        return calculateMoney(index + 1, money % moneyList[index], result)
    }
    return  calculateMoney(index + 1, money, result)
}