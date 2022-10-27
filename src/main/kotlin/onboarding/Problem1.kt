package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(!(exception(pobi) && exception(crong))) return -1

    return 0
}

fun exception(user: List<Int>) : Boolean {

    if(user[0] % 2 != 1 || user[1] % 2 != 0) return false
    if(user[0] + 1 != user[1]) return false
    if(user[0] <= 1 || user[1] >= 400) return false

    return true
}

fun addPageNum(pageNum : Int) : Int {
    var sum = 0
    var page = pageNum

    while(page > 0) {
        sum += page % 10
        page /= 10
    }

    return sum
}

fun multiPageNum(pageNum: Int) : Int {
    var sum = 1
    var page = pageNum

    while(page > 0) {
        sum *= page % 10
        page /= 10
    }

    return sum
}
fun compare_addPageNum_multiPageNum(pageNum: Int) : Int {
    return max(addPageNum(pageNum), multiPageNum(pageNum))
}
