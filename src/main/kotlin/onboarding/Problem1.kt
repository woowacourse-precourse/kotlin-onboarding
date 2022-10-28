package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if ((pobi[0]%2 != 1) or (pobi[1]%2 != 0)) {
        return -1
    } else if ((crong[0]%2 != 1) or (crong[1]%2 != 0)) {
        return -1
    } else if (pobi[0]+1 != pobi[1]) {
        return -1
    } else if (crong[0]+1 != crong[1]) {
        return -1
    } else if ((pobi[0]<=1) or (pobi[1]>=400)) {
        return -1
    } else if ((crong[0]<=1) or (crong[1]>=400)) {
        return -1
    }

    if ((pobi.size != 2) or (crong.size != 2)){
        return -1
    }

    var pobiLeft = pobi[0]
    var pobiRight = pobi[1]
    var crongLeft = crong[0]
    var crongRight = crong[1]
    var pobiLeftsum = 0
    var pobiLeftmul = 1
    var pobiRightsum = 0
    var pobiRightmul = 1
    var crongLeftsum = 0
    var crongLeftmul = 1
    var crongRightsum = 0
    var crongRightmul = 1

    while(pobiLeft>=1){
        pobiLeftsum += pobiLeft % 10
        pobiLeftmul *= pobiLeft % 10
        pobiLeft /= 10
    }
    while(pobiRight>=1){
        pobiRightsum += pobiRight % 10
        pobiRightmul *= pobiRight % 10
        pobiRight /= 10
    }
    while(crongLeft>=1){
        crongLeftsum += crongLeft % 10
        crongLeftmul *= crongLeft % 10
        crongLeft /= 10
    }
    while(crongRight>=1){
        crongRightsum += crongRight % 10
        crongRightmul *= crongRight % 10
        crongRight /= 10
    }

    var answer = 0
    var pobiBigger = 0
    var crongBigger = 0

    if (pobiLeftsum >= pobiLeftmul){
        if (pobiRightsum >= pobiRightmul){
            if (pobiLeftsum >= pobiRightsum){
                pobiBigger = pobiLeftsum
            } else {
                pobiBigger = pobiRightsum
            }
        }
        else {
            if (pobiLeftsum >= pobiRightmul){
                pobiBigger = pobiLeftsum
            } else {
                pobiBigger = pobiRightmul
            }
        }
    } else{
        if (pobiRightsum >= pobiRightmul){
            if (pobiLeftmul >= pobiRightsum){
                pobiBigger = pobiLeftmul
            } else {
                pobiBigger = pobiRightsum
            }
        }
        else {
            if (pobiLeftmul >= pobiRightmul){
                pobiBigger = pobiLeftmul
            } else {
                pobiBigger = pobiRightmul
            }
        }
    }

    if (crongLeftsum >= crongLeftmul){
        if (crongRightsum >= crongRightmul){
            if (crongLeftsum >= crongRightsum){
                crongBigger = crongLeftsum
            } else {
                crongBigger = crongRightsum
            }
        }
        else {
            if (crongLeftsum >= crongRightmul){
                crongBigger = crongLeftsum
            } else {
                crongBigger = crongRightmul
            }
        }
    } else{
        if (crongRightsum >= crongRightmul){
            if (crongLeftmul >= crongRightsum){
                crongBigger = crongLeftmul
            } else {
                crongBigger = crongRightsum
            }
        }
        else {
            if (crongLeftmul >= crongRightmul){
                crongBigger = crongLeftmul
            } else {
                crongBigger = crongRightmul
            }
        }
    }

    if (pobiBigger > crongBigger){
        answer = 1
    } else if (pobiBigger < crongBigger){
        answer = 2
    } else {
        answer = 0
    }

    return answer

}
