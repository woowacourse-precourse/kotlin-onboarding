package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1 || pobi[0] < 1 || pobi[1] > 400 || crong[0] < 1 || crong[1] > 400)
        return -1


    val pobiValue : Int = max(max(getPlusValue(pobi[0]), getPlusValue(pobi[1])), max(getMultiplyValue(pobi[0]), getMultiplyValue(pobi[1])))

    val crongValue : Int = max(max(getPlusValue(crong[0]), getPlusValue(crong[1])), max(getMultiplyValue(crong[0]), getMultiplyValue(crong[1])))


    return if(pobiValue > crongValue)
        1
    else if(pobiValue <  crongValue)
        2
    else
        0
}

fun getPlusValue(num: Int): Int {
    var str: String = num.toString()
    var value: Int = 0

    for (element in str) {
        value += element.digitToInt()

    }

    return value
}

fun getMultiplyValue(num: Int): Int {
    var str: String = num.toString()
    var value: Int = 1

    for (element in str) {
        value *= element.digitToInt()
    }


    return value
}