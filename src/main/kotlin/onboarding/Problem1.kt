package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(!isValidPage(pobi, crong))
        return -1


    val pobiValue : Int = getMaxValue(pobi)

    val crongValue : Int = getMaxValue(crong)


    return if(pobiValue > crongValue)
        1
    else if(pobiValue <  crongValue)
        2
    else
        0
}

fun getMaxValue(page : List<Int>): Int {
    var leftPage = page[0]
    var rightPage = page[1]
    var leftPlusValue: Int = 0
    var rightPlusValue : Int = 0
    var leftMultiValue : Int = 1
    var rightMultiValue : Int = 1

    while(leftPage != 0){
        leftPlusValue += leftPage % 10
        leftMultiValue *= leftPage % 10

        leftPage /= 10
    }

    while(rightPage != 0){
        rightPlusValue += rightPage % 10
        rightMultiValue *= rightPage % 10

        rightPage /= 10
    }

    return max(max(leftPlusValue, leftMultiValue), max(rightPlusValue, rightMultiValue))
}

fun isValidPage(pobi : List<Int>, crong : List<Int>) : Boolean{
    return pobi[1] - pobi[0] == 1 && crong[1] - crong[0] == 1 && pobi[0] in 1..399 && crong[0] in 1..399 && pobi[0] % 2 == 1 && crong[0] % 2 == 1
}
