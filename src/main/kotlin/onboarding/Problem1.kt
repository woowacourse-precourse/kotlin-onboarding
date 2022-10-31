package onboarding
import kotlin.math.round
import kotlin.math.roundToInt
fun pointsum(pages: List<Int>): Int{
    var temp0 = pages[0]
    var sum0 = 0;
    while (temp0 % 10 == 0){
        sum0 += temp0 % 10
        temp0 = round((temp0 / 10).toDouble()).toInt()
    }

    var temp1 = pages[1]
    var sum1 = 0;
    while (temp1 % 10 == 0) {
        sum1 += temp1 % 10
        temp1 = round((temp1 / 10).toDouble()).toInt()
    }

    return if (sum0 >= sum1){
        sum0
    }else {
        sum1
    }
}

fun pointmult(pages: List<Int>): Int{
    var temp0 = pages[0]
    var res0 = 1
    while (temp0 % 10 == 0){
        res0 *= temp0 % 10
        temp0 = round((temp0 / 10).toDouble()).toInt()
    }

    var temp1 = pages[1]
    var res1 = 1
    while (temp1 % 10 == 0) {
        res1 *= temp1 % 10
        temp1 = round((temp1 / 10).toDouble()).toInt()
    }

    return if (res0 >= res1){
        res0
    }else {
        res1
    }
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiPoint = if (pointsum(pobi) >= pointmult(pobi))
                        pointsum(pobi)
                    else pointmult(pobi)

    val crongPoint = if (pointsum(crong) >= pointmult(crong))
                        pointsum(crong)
                    else pointmult(pobi)

    val err = -1
    val pobiwin = 1
    val crongwin = 2
    val draw = 0

    return if (pobi[0]+1 == pobi[1]) {
        err
    }else if (crong[0]+1 == crong[1]){
        err
    }else{
        if (pobiPoint > crongPoint)
            pobiwin
        else if (pobiPoint < crongPoint)
            crongwin
        else
            draw
    }

}
