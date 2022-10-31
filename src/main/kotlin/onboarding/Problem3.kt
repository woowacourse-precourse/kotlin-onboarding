package onboarding

fun getCount(number: Int): Int {
    var cnt = 0

    val strNumber = number.toString()

    for(i in strNumber.indices) {
        if(strNumber[i] == '3' || strNumber[i] == '6' || strNumber[i] == '9')
            cnt++
    }

    return cnt
}
fun solution3(number: Int): Int {
    var result = 0

    for(i in 1 .. number) {
        result += getCount(i)
    }

    return result
}
