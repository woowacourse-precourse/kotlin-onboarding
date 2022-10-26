package onboarding

fun solution3(number: Int): Int {
    var cnt:Int = 0

    for (i in 1..number){
        cnt += countClap(i)
    }
    return cnt
}

fun countClap(x: Int): Int {
    var numX:Int = x
    var cnt:Int = 0

    while(numX > 0){
        if (numX%10 == 3 || numX%10 == 6 || numX%10 == 9)
            cnt++
        numX /= 10
    }
    return cnt
}
