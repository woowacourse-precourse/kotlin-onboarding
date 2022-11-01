package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val poPoint = getMax(pobi)
    val crPoint = getMax(crong)

    if(poPoint>crPoint) return 1;
    if(poPoint==crPoint) return 0;
    if(poPoint<crPoint) return 2
    return -1


}

fun getMax(arr:List<Int>):Int{
    val a = arr[0]
    val b = arr[1]

    var aSum = 0
    var aMul = 1
    a.toString().forEach {
        aSum+=it-'0'
        aMul*=it-'0'
    }
    val aRes = max(aSum,aMul)

    var bSum=0
    var bMul=1
    b.toString().forEach {
        bSum+=it-'0'
        bMul*=it-'0'
    }
    val bRes = max(bSum,bMul)

    return max(aRes,bRes)
}