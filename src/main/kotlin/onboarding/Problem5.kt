package onboarding

fun solution5(money: Int): List<Int> {

    val moneyList: List<Int> = listOf(오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원)
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

const val 오만원 = 50000
const val 만원 = 10000
const val 오천원 = 5000
const val 천원 = 1000
const val 오백원 = 500
const val 백원 = 100
const val 오십원 = 50
const val 십원 = 10
const val 일원 = 1