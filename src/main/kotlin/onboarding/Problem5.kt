package onboarding

import kotlin.collections.ArrayList

fun solution5(money: Int): List<Int> {
    val list = ArrayList<Int>()
    var curMoney = money

    val price = arrayListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    price.forEach {
        list.add(curMoney / it)
        curMoney %= it
    }

    return list
}
