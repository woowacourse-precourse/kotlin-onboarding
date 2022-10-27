package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(!(exception(pobi) && exception(crong))) return -1

    return compare_users(pobi, crong)
}

fun exception(user: List<Int>) : Boolean {

    if(user[0] % 2 != 1 || user[1] % 2 != 0) return false
    if(user[0] + 1 != user[1]) return false
    if(user[0] <= 1 || user[1] >= 400) return false

    return true
}

fun addPageNum(pageNum : Int) : Int =
        pageNum.toString().map {
            it.toInt() - '0'.toInt()
        }.sum()

fun multiPageNum(pageNum: Int) : Int =
        pageNum.toString().map {
            it.toInt() - '0'.toInt()
        }.reduce { acc, i ->  acc * i}

fun compare_addPageNum_multiPageNum(pageNum: Int) : Int {
    return max(addPageNum(pageNum), multiPageNum(pageNum))
}

fun compare_leftPage_rightPage(user : List<Int>) : Int {
    val left = compare_addPageNum_multiPageNum(user[0])
    val right = compare_addPageNum_multiPageNum(user[1])

    return max(left, right)
}

fun compare_users(pobi: List<Int>, crong: List<Int>) : Int {

    val pobiScore = compare_leftPage_rightPage(pobi)
    val crongScore = compare_leftPage_rightPage(crong)

    if(pobiScore > crongScore) {
        return 1
    }
    if(pobiScore < crongScore) {
        return 2
    }
    return 0
}