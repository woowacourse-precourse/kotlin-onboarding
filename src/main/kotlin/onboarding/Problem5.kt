package onboarding

fun solution5(money: Int): List<Int> {
    return listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
        .mapWithFold(money) { balance, unit ->
            balance % unit to balance / unit
        }
}

private inline fun <I, T, R> Iterable<T>.mapWithFold(initial: I, transform: (I, T) -> Pair<I, R>): List<R> {
    var accumulator = initial
    val destination = mutableListOf<R>()

    for (item in this) {
        val (acc2, item2) = transform(accumulator, item)
        accumulator = acc2
        destination.add(item2)
    }

    return destination
}