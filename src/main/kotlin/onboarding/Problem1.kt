package onboarding

import java.lang.Integer.max

const val EXECPTION = -1
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
    return pages[1] - pages[0] == 0
}
fun checkLength(pages : List<Int>) : Boolean{
    return pages.size == 2
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiLeft : Int = pobi[0]
    val pobiRight : Int = pobi[1]
    val crongLeft : Int = crong[0]
    val crongRight : Int = crong[1]

    if(!continuous(pobi) || !continuous(crong) ||  !checkLength(pobi) || !checkLength(crong)){
        return EXECPTION
    }

    val pobiResult = max(maxPageNumber(pobiLeft), maxPageNumber(pobiRight))
    val crongResult = max(maxPageNumber(crongLeft), maxPageNumber(crongRight))

    return when {
        crongResult > pobiResult -> CRONG_WIN
        crongResult < pobiResult -> POBI_WIN
        else -> DRAW
    }

}