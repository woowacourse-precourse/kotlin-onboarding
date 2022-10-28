package onboarding

fun solution5(money: Int): List<Int> {
    val monetaryUnit = arrayListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var change = arrayListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    var m = money

    for (i in 0 until monetaryUnit.size) {
        change[i] =  m / monetaryUnit[i]
        m %= monetaryUnit[i]
    }

    return change
}

fun main() {
    println(solution5(50237))
    println(solution5(15000))

}
