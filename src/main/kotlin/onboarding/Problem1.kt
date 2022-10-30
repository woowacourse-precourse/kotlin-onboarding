package onboarding

import java.lang.Integer.max

const val EXCEPTION_PAGE_SIZE = 2
const val EXCEPTION = -1
const val CONTINUOUS = 1

const val POBI_WIN = 1
const val CRONG_WIN = 2
const val DRAW = 0
fun getMaxPageNumber(number : Int) : Int{
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
fun isContinuous(pages : List<Int>) : Boolean{
    return pages[1] - pages[0] == CONTINUOUS
}
fun checkSize(pages : List<Int>) : Boolean{
    return pages.size == EXCEPTION_PAGE_SIZE
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!isContinuous(pobi) || !isContinuous(crong) || !checkSize(pobi) || !checkSize(crong))
        return EXCEPTION

    val pobiLeftPage : Int = pobi[0]
    val pobiRightPage : Int = pobi[1]
    val crongLeftPage : Int = crong[0]
    val crongRightPage : Int = crong[1]

    val pobiResult = max(getMaxPageNumber(pobiLeftPage), getMaxPageNumber(pobiRightPage))
    val crongResult = max(getMaxPageNumber(crongLeftPage), getMaxPageNumber(crongRightPage))

    return when {
        crongResult > pobiResult -> CRONG_WIN
        crongResult < pobiResult -> POBI_WIN
        else -> DRAW
    }
}