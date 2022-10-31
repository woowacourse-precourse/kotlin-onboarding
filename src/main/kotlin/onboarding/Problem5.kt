package onboarding

fun solution5(money: Int): List<Int> {
    val result: MutableList<Int> = mutableListOf()
    val unit: List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var currentMoney = money

    for(element in unit) {
        result.add(currentMoney/ element)
        currentMoney %= element
    }
    return result
}
