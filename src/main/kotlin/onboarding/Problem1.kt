package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>):Int {
    val pobiMax = findMaxValue(pobi)
    val crongMax = findMaxValue(crong)

    return if (pobiMax == crongMax){
        0
    }
    else if (pobiMax > crongMax){
        1
    }
    else {
        2
    }
}

fun findMaxValue(list: List<Int>) : Int {
    val values = arrayListOf<Int>()
    var multi = 1

    for (i in list) {
        val digits = i.toString().map {
            it.code - '0'.code
        }
        digits.forEach { multi *= it }
        values.add(digits.sum())
        values.add(multi)
    }

    if (values.maxOrNull() == null) {
        return 0
    }

    return values.maxOrNull()!!
}
