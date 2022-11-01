package onboarding

fun main() {
    solution5(50237).forEach { print("$it ") }
    println()
    solution5(15000).forEach { print("$it ") }
}

fun solution5(money: Int): List<Int> {
    val units = intArrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    var current = money

    for (index in units.indices) {
        while (current - units[index] >= 0) {
            current -= units[index]
            result[index]++

            if (current == 0) break
        }
    }

    return result.toList()
}
