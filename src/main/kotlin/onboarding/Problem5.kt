package onboarding

fun solution5(money: Int): List<Int> {
    val money = money

    if(isCorrect5(money)) {
        val fiveTenThousands = money / 50000
        val tenThousands = (money % 50000) / 10000
        val fiveThousands = (money % 10000) / 5000
        val thousands = (money % 5000) / 1000
        val fiveHundreds = (money % 1000) / 500
        val hundreds = (money % 500) / 100
        val fiveTens = (money % 100) / 50
        val tens = (money % 50) / 10
        val units = money % 10

        val result = listOf(
                fiveTenThousands, tenThousands,
                fiveThousands, thousands,
                fiveHundreds, hundreds,
                fiveTens, tens,
                units
        )
        return result
    }
    else return listOf(-1)
}

fun isCorrect5(money: Int): Boolean {
    val condition1 = money in 1..1000000
    return condition1
}
