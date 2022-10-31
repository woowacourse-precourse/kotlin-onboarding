package onboarding

fun solution5(money: Int): List<Int> {
    var m = money
    val result = MutableList(9) { 0 }
    val changes = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    changes.forEachIndexed { i, c ->
        if (m >= c) {
            result[i] = m / c
            m %= c
        }
    }
    return result
}