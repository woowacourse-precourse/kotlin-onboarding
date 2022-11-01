package onboarding

fun solution5(money: Int): List<Int> {
    var N = money
    var list = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
    var result = mutableListOf<Int>()

    for (i in list){
        result.add(N/i)
        N %= i
    }
    println(result)
    return result
}
