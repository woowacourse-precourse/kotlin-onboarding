package onboarding

import java.lang.IllegalArgumentException

fun solution3(number: Int): Int {

    exception(number)


    return 0
}

fun exception(number: Int) {
    if(number < 1 || number > 1000) {
        throw IllegalArgumentException("number는 1이상 1000이하여야 합니다.")
    }
}

fun clapNum(num : Int): Int {
    return num.toString().count { c -> (c == '3' || c == '6' || c == '9')}
}


