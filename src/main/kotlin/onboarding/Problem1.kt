package onboarding

import kotlin.math.max

fun isException(pages: List<Int>): Boolean{
    if(pages[0]+1!=pages[1]) return true
    return false
}

fun findMaxValue(num: Int): Int{
    var plusRes = 0
    var multiRes = 1
    var n = num
    while (n>0){
        val tmp = n%10
        plusRes+=tmp
        multiRes*=tmp
        n/=10
    }
    return max(plusRes, multiRes)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}
