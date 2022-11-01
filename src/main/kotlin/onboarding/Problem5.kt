package onboarding

import java.util.*
import kotlin.collections.ArrayList

fun solution5(money: Int): List<Int> {
    val units = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val num = ArrayList(Collections.nCopies(9, 0))

    var temp = money
    for(i in units.indices){
        num[i] = temp / units[i]
        temp %= units[i]
    }

    return num
}
