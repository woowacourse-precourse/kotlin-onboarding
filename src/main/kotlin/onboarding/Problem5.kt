package onboarding

fun solution5(money: Int): List<Int> {
    val units = listOf(
        50000, 10000, 5000,
        1000, 500, 100,
        50, 10, 1
    )

    val counts = mutableListOf<Int>()

    var remain = money
    for (unit in units) {
        if (remain < 0) break
        val cnt = availableCnt(remain, unit)
        counts.add(cnt)

        remain -= cnt * unit
    }

    return counts
}

private fun availableCnt(money: Int, unit: Int): Int {
    return money / unit
}