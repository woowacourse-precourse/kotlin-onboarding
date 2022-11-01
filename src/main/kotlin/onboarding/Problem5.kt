package onboarding

fun solution5(money: Int): List<Int> {
    val result =mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    val units = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var input = money
    for(i in units.indices){
        result[i] = input/units[i]
        input%= units[i]
    }
    return result
}

