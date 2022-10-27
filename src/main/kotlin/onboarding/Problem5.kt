package onboarding

fun solution5(money: Int): List<Int> {
    val change = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var result = exchange(money, change)
    return result
}

fun exchange(money : Int, change : List<Int>) : List<Int>{
    var money = money
    var result : MutableList<Int> = mutableListOf()
    for(i in change){
        result.add(money/i)
        money %= i
    }
    return result
}