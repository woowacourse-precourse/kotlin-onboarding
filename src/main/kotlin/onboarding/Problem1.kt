package onboarding

import java.lang.Integer.max

fun getMaxNumber(number : Int) : Int{
    var plus = 0
    var multiple = 1
    var temp = number

    while(temp > 0){
        plus += temp % 10
        multiple *= temp % 10

        temp /= 10
    }
    return max(plus, multiple)
}
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobiLeft : Int = pobi[0]
    var pobiRight : Int = pobi[1]
    var pobiResult : Int?

    var crongLeft : Int = crong[0]
    var crongRight : Int = crong[1]
    var crongResult : Int?

    if(pobiRight - 1 != pobiLeft || crongRight - 1 != crongLeft)
        return -1

    pobiResult = max(getMaxNumber(pobiLeft), getMaxNumber(pobiRight))
    crongResult = max(getMaxNumber(crongLeft), getMaxNumber(crongRight))

    if(crongResult > pobiResult){
        return 2
    }
    if(pobiResult > crongResult){
        return 1
    }

    return 0
}