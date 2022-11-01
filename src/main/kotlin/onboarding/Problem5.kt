package onboarding

fun solution5(money: Int): List<Int> {

    var exchange = mutableListOf<Int>(0,0,0,0,0,0,0,0,0)
    val coins = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var ex = money
    var num = 0


    for (i in coins){
        val count = ex / i
        if (count != 0){
            ex %= i
            exchange[num] = count
        }
        num += 1
    }


    return exchange
}
