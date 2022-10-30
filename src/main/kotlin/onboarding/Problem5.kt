package onboarding

fun solution5(money: Int): List<Int> {
    val units = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var changes = money

    return units.map {
        val count = changes / it
        changes %= it
        count
    }.toList()
}
