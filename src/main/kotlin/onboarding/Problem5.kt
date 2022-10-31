package onboarding

import java.util.*

class Money(val amount: Int) {
    fun quotient(money: Money) = amount / money.amount
    fun remainder(money: Money) = Money(amount % money.amount)
}

class Wallet(private val moneyMap: SortedMap<Money, Int>) {
    fun addMoneyNum(money: Money, moneyNum: Int) {
        moneyMap[money] = moneyMap[money]!!.plus(moneyNum)
    }

    fun isFitRemainderInMap(remainder: Money): Boolean {
        if (moneyMap[remainder] != null) {
            addMoneyNum(remainder, 1)
            return true
        }
        return false
    }

    fun moneyList() = moneyMap.keys.toList()

    fun moneyNumList() = moneyMap.values.toList()
}

fun solution5(money: Int): List<Int> {
    val wallet = Wallet(
        sortedMapOf(
            { a, b -> b.amount - a.amount },
            Money(50000) to 0, Money(10000) to 0, Money(5000) to 0,
            Money(1000) to 0, Money(500) to 0, Money(100) to 0,
            Money(50) to 0, Money(10) to 0, Money(1) to 0
        )
    )

    val moneyList = wallet.moneyList()
    var currMoney = Money(money)
    var i = 0

    while (currMoney.amount != 0) {
        val quotient = currMoney.quotient(moneyList[i])
        val remainder = currMoney.remainder(moneyList[i])

        wallet.addMoneyNum(moneyList[i], quotient)

        if (wallet.isFitRemainderInMap(remainder)) break

        currMoney = remainder
        i++
    }

    return wallet.moneyNumList()
}