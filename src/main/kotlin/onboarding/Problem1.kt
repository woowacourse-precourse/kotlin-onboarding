package onboarding

import kotlin.math.max

fun calScore(user: List<Int>): Int{

    val rightMax: Int = pageScore(user[0])

    val leftMax: Int = pageScore(user[1])


    return max(rightMax, leftMax)

}

fun pageScore(number: Int): Int{
    // plus
    var scorePlus = 0

    //mul
    var scoreMul = 1

    var pageNumber: Int = number
    while (pageNumber > 0){
        val num: Int = pageNumber % 10

        scorePlus += num
        scoreMul *= num
        pageNumber /= 10
    }
    return max(scoreMul, scorePlus)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiScore: Int = calScore(pobi)
    val crongScore: Int = calScore(crong)

    if (((pobi[0] % 2 == 1) && (pobi[0] + 1 == pobi[1])) && ((crong[0] % 2 == 1) && (crong[0] + 1 == crong[1]))){
        if (pobiScore > crongScore) {
            return 1
        }else if(pobiScore < crongScore) {
            return 2
        }else {
            return 0
        }
    }
    return -1
}
