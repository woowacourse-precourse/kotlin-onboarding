package onboarding

import kotlin.math.*;

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[0]+1 != pobi[1] || crong[0]+1 != crong[1]) {
        return -1;
    }
    var temp: Int

    var pobiLeft1 : Int = 0
    var pobiLeft2 : Int = 1
    temp = pobi[0]
    while(temp > 0) {
        pobiLeft1 += temp % 10
        pobiLeft2 *= temp % 10
        temp /= 10
    }

    var pobiRight1 : Int = 0
    var pobiRight2 : Int = 1
    temp = pobi[1]
    while(temp > 0) {
        pobiRight1 += temp % 10
        pobiRight2 *= temp % 10
        temp /= 10
    }

    var crongLeft1 : Int = 0
    var crongLeft2 : Int = 1
    temp = crong[0]
    while(temp > 0) {
        crongLeft1 += temp % 10
        crongLeft2 *= temp % 10
        temp /= 10
    }

    var crongRight1 : Int = 0
    var crongRight2 : Int = 1
    temp = crong[1]
    while(temp > 0) {
        crongRight1 += temp % 10
        crongRight2 *= temp % 10
        temp /= 10
    }

    var pobiMAX:Int = listOf(pobiLeft1, pobiLeft2, pobiRight1, pobiRight2).maxOrNull()?:0
    var crongMAX:Int = listOf(crongLeft1, crongLeft2, crongRight1, crongRight2).maxOrNull()?:0

    if(pobiMAX == crongMAX) {
        return 0
    } else if(pobiMAX > crongMAX) {
        return 1
    } else {
        return 2
    }
}