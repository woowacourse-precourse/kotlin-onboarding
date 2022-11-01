package onboarding

fun solution5(money: Int): List<Int> {
    val monetaryUnits = arrayOf(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1)
    var result = mutableListOf<Int>()

    monetaryUnits.fold(money) { acc, unit ->
        result.add(acc.div(unit))
        acc.rem(unit)
    }

    return result
}

fun validateMoney(money: Int) {
    if (money !in 1..1_000_000)
        throw IllegalArgumentException("출금하는 돈의 액수는 1원 이상 100만원 이하여야 합니다.")
}
