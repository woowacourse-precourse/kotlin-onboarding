package onboarding


fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    var pobiScore = 0
    var crongScore = 0

    val result: Int

    var pobiLeftPagePlus = 0
    var pobiLeftPageMul = 1
    var pobiLeftPageSum = 0

    var pobiRightPagePlus = 0
    var pobiRightPageMul = 1
    var pobiRightPageSum = 0

    var crongLeftPagePlus = 0
    var crongLeftPageMul = 1
    var crongLeftPageSum = 0

    var crongRightPagePlus = 0
    var crongRightPageMul = 1
    var crongRightPageSum = 0

    var pnum1: Int = pobi.first()
    var pnum2: Int = pobi.last()

    var cnum1: Int = crong.first()
    var cnum2: Int = crong.last()

    if (pnum1 > 1 && pnum2 < 400 && cnum1 > 1 && cnum2 < 400) {
    if ((pnum2 - pnum1) > 1 || (cnum2 - cnum1) > 1) {
        result = -1
        return result
    } else {

    while (pnum1 != 0 ) {
        pobiLeftPagePlus += pnum1 % 10
        pobiLeftPageMul *= pnum1 % 10
        pnum1 /= 10
    } //포비 왼쪽페이지 더한거, 곱한거 구하기

    while (cnum1 != 0) {
        crongLeftPagePlus += cnum1 % 10
        crongLeftPageMul *= cnum1 % 10
        cnum1 /= 10
    } //크롱 왼쪽페이지 더한거, 곱한거 구하기

    while (pnum2 != 0) {
        pobiRightPagePlus += pnum2 % 10
        pobiRightPageMul *= pnum2 % 10
        pnum2 /= 10
    } //포비 오른쪽페이지 더한거, 곱한거 구하기

    while (cnum2 != 0) {
        crongRightPagePlus += cnum2 % 10
        crongRightPageMul *= cnum2 % 10
        cnum2 /= 10
    } //크롱 오른쪽페이지 더한거, 곱한거 구하기

    if (pobiLeftPageMul > pobiLeftPagePlus) {
        pobiLeftPageSum = pobiLeftPageMul
    }
    else if (pobiLeftPageMul <= pobiLeftPagePlus) {
        pobiLeftPageSum = pobiLeftPagePlus
    }//포비 왼쪽페이지 더한거, 곱한거에서 큰거 sum에 넣기

    if (crongLeftPageMul > crongLeftPagePlus) {
        crongLeftPageSum = crongLeftPageMul
    }
    else if (crongLeftPageMul <= crongLeftPagePlus) {
        crongLeftPageSum = crongLeftPagePlus
    } //크롱 왼쪽페이지 더한거, 곱한거에서 큰거 sum에 넣기

    if (pobiRightPageMul > pobiRightPagePlus) {
        pobiRightPageSum = pobiRightPageMul
    }
    else if (pobiRightPageMul <= pobiRightPagePlus) {
        pobiRightPageSum = pobiRightPagePlus
    }//포비 왼쪽페이지 더한거, 곱한거에서 큰거 sum에 넣기

    if (crongRightPageMul > crongRightPagePlus) {
        crongRightPageSum = crongRightPageMul
    }
    else if (crongRightPageMul <= crongRightPagePlus) {
        crongRightPageSum = crongRightPagePlus
    }//크롱 오른쪽페이지 더한거, 곱한거에서 큰거 sum에 넣기

    if (pobiLeftPageSum > pobiRightPageSum) {
        pobiScore = pobiLeftPageSum
    }
    else if (pobiLeftPageSum < pobiRightPageSum) {
        pobiScore = pobiRightPageSum
    }

    if (crongLeftPageSum > crongRightPageSum) {
        crongScore = crongLeftPageSum
    }
    else if (crongLeftPageSum < crongRightPageSum) {
        crongScore = crongRightPageSum
    }

    if (pobiScore > crongScore) {
       result = 1
    }
    else if (pobiScore < crongScore) {
        result = 2
    }
    else if (pobiScore == crongScore) {
        result = 0
    }
    else result = -1

    }
    } else {
        result = -1
        return result
    }
    println("aaa" + pobiScore)
    println("bbb" + crongScore)
    println("ccc" + result)

    return result
}