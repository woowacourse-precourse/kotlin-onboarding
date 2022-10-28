package onboarding

import java.util.*
import kotlin.collections.ArrayList

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1)
        return -1

    val pobiMax:Int = calculateMax(pobi)
    val crongMax:Int = calculateMax(crong)


    return 0

}
fun calculateMax(pageList:List<Int>): Int{

    val resultList:ArrayList<Int> = arrayListOf()
    for(page in pageList){

        var pagePlus = 0
        var pageMultiply = 1
        var page_temp = page

        while (page_temp != 0){

            pagePlus += page_temp  % 10
            pageMultiply *= page_temp % 10

            page_temp /= 10
        }
        resultList.add(pagePlus)
        resultList.add(pageMultiply)

    }
    return Collections.max(resultList)

}