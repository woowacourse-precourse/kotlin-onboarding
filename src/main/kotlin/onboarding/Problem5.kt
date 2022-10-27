package onboarding

fun solution5(money: Int): List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1).mapIndexed { index, i ->
    if (index == 0) money / i
    else if (index == 8) (money % 10)
    else if (index % 2 == 0) (money % (i * 2)) / i
    else (money % (i * 5)) / i
}