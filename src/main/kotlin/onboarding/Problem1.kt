package onboarding

import java.lang.Integer.max

const val EXCPTION_PAGE_SIZE = 2
const val EXECPTION = -1
const val CONTINOUS = 1

const val POBI_WIN = 1
const val CRONG_WIN = 2
const val DRAW = 0
fun maxPageNumber(number : Int) : Int{
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
fun continuous(pages : List<Int>) : Boolean{
    return pages[1] - pages[0] == CONTINOUS
}
fun checkLength(pages : List<Int>) : Boolean{
    return pages.size == EXCPTION_PAGE_SIZE
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!continuous(pobi) || !continuous(crong))
        return EXECPTION

    if(!checkLength(pobi) || !checkLength(crong))
        return EXECPTION

    val pobiLeftPage : Int = pobi[0]
    val pobiRightPage : Int = pobi[1]
    val crongLeftPage : Int = crong[0]
    val crongRightPage : Int = crong[1]

    val pobiResult = max(maxPageNumber(pobiLeftPage), maxPageNumber(pobiRightPage))
    val crongResult = max(maxPageNumber(crongLeftPage), maxPageNumber(crongRightPage))

    return when {
        crongResult > pobiResult -> CRONG_WIN
        crongResult < pobiResult -> POBI_WIN
        else -> DRAW
    }
}