package onboarding

val MONEY = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

fun solution5(money: Int): List<Int> {
    val result = MutableList<Int>(9){0}
    return  calculateMoney(0, money, result)
}

fun calculateMoney(index : Int, money : Int, result : MutableList<Int>) : List<Int> {
    if (money == 0) {
        return result
    }
    if (money / MONEY[index] != 0) {
        result[index] = (money / MONEY[index])
        return calculateMoney(index + 1, money % MONEY[index], result)
    }
    return  calculateMoney(index + 1, money, result)
}