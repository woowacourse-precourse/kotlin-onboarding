package onboarding

import java.util.*
import kotlin.collections.ArrayList

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if ((pobi[1] - pobi[0] != 1) || (crong[1] - crong[0] != 1)) {
        return -1
    }

    val pobiMax:Int = calculateMax(pobi)
    val crongMax:Int = calculateMax(crong)

    if (pobiMax > crongMax){
        return 1
    }
    if (pobiMax < crongMax){
        return 2
    }
    return 0

}

fun calculateMax(pageList:List<Int>): Int{
    val resultList:ArrayList<Int> = arrayListOf()

    for(page in pageList){
        resultList.add(calculatePlus(page))
        resultList.add(calculateMultiply(page))
    }
    return Collections.max(resultList)

}

fun calculatePlus(page:Int) : Int{
    var calculatePage=page
    var pageResult = 0
    while (calculatePage != 0) {

        pageResult += calculatePage % 10
        calculatePage /= 10
    }
    return pageResult

}

fun calculateMultiply(page:Int) : Int {
    var calculatePage=page
    var pageResult = 1

    while (calculatePage != 0) {
        pageResult += calculatePage % 10
        calculatePage /= 10
    }

    return pageResult
}