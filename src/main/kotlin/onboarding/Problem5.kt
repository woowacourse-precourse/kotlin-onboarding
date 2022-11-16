package onboarding

fun solution5(money: Int): List<Int> {

    val moneyList: List<Int> = listOf(
            FIFTY_THOUS,
            TEN_THOUS,
            FIVE_THOUS,
            ONE_THOUS,
            FIVE_HUND,
            ONE_HUND,
            FIFTY,
            TEN,
            ONE
        )

    val moneyCountList = mutableListOf<Int>()
    var restMoney = money

    moneyList.map {
        val moneyCount = restMoney / it
        val moneyCountIsNotZero = (moneyCount != 0)

        if (moneyCountIsNotZero) {
            moneyCountList.add(moneyCount)
            restMoney -= moneyCount * it
        }

        if (!moneyCountIsNotZero) {
            moneyCountList.add(0)
        }
    }

    return moneyCountList

}

const val FIFTY_THOUS = 50_000
const val TEN_THOUS = 10_000
const val FIVE_THOUS = 5_000
const val ONE_THOUS = 1_000
const val FIVE_HUND = 500
const val ONE_HUND = 100
const val FIFTY = 50
const val TEN = 10
const val ONE = 1