package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(!isValidPage(pobi, crong))
        return -1


    val pobiValue : Int = compareGetMaxNum(pobi)

    val crongValue : Int = compareGetMaxNum(crong)


    return if(pobiValue > crongValue)
        1
    else if(pobiValue <  crongValue)
        2
    else
        0
}

fun getMaxValue(page : Int): Int {
    var pageNum = page
    var plusValue: Int = 0
    var multiValue : Int = 1

    while(pageNum != 0){
        plusValue += pageNum % 10
        multiValue *= pageNum % 10

        pageNum /= 10
    }


    return max(plusValue, multiValue)
}

fun compareGetMaxNum(pages : List<Int>) : Int{
    var leftMaxValue = getMaxValue(pages[0])
    var rightMaxValue = getMaxValue(pages[1])

    return max(leftMaxValue, rightMaxValue)
}

fun isValidPage(pobi : List<Int>, crong : List<Int>) : Boolean{
    return pobi[1] - pobi[0] == 1 && crong[1] - crong[0] == 1 && pobi[0] in 1..399 && crong[0] in 1..399 && pobi[0] % 2 == 1 && crong[0] % 2 == 1
}
