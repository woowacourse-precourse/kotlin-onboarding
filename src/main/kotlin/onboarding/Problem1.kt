package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>):Int {
    return 0
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
