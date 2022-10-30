package onboarding

fun solution5(money: Int): List<Int> {
    val bills: List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var result = mutableListOf<Int>()
    var balance: Int = money

    for (bill in bills){
        result.add(balance/bill)
        balance %= bill
    }
    return result
}
