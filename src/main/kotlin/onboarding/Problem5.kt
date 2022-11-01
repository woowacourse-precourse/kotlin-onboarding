package onboarding

fun solution5(money: Int): List<Int> {

    var tmp_money : Int = money

    val currencyType : List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val count : MutableList<Int> = MutableList(9) {0}

    for(i in 0 until 9) {
        count[i] = tmp_money / currencyType[i]
        tmp_money -= count[i] * currencyType[i]
    }

    return count
}