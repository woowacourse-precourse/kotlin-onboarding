package onboarding

import java.lang.IllegalArgumentException

fun solution3(number: Int): Int {

    exception(number)

    return all_clapNum(number)
}

fun exception(number: Int) {
    if(number < 1 || number > 10000) {
        throw IllegalArgumentException("number는 1이상 10000이하여야 합니다.")
    }
}

fun clapNum(num : Int): Int {
    return num.toString().count { c -> (c == '3' || c == '6' || c == '9')}
}

fun all_clapNum(number: Int) : Int {

    var sum = 0

    for(i in 1..number) {
        sum += clapNum(i)
    }

    return sum
}


