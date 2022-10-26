package onboarding

fun checkOddEvenContinue(pobi: List<Int>, crong: List<Int>): Boolean {
    for(i in 0 until 2) {
        when(i) {
            0 -> {
                if(pobi[i] % 2 != 1 || crong[i] % 2 != 1)
                    return false
            }
            1 -> {
                if(pobi[i] != pobi[0] + 1 || crong[i] != crong[0] + 1)
                    return false
            }
        }
    }
    return true
}

fun checkNormalPage(pobi: List<Int>, crong: List<Int>): Boolean {
    for(i in 0 until 2) {
        if(pobi[i] <= 1 || pobi[i] >= 400 )
            return false
        if(crong[i] <= 1 || crong[i] >= 400)
            return false
    }
    return true
}

fun integer_max(a: Int, b: Int): Int {
    if( a > b)
        return a
    else
        return b
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(checkOddEvenContinue(pobi, crong) && checkNormalPage(pobi, crong)) {

    }
    return -1
}
