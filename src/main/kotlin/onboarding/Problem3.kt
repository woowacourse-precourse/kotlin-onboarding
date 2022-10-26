package onboarding

fun solution3(number: Int): Int {
    var cnt:Int = 0

    for (i in 1..number){
        cnt += countClap(i)
    }
}

fun countClap(x: Int): Int {
    var numX:Int = x
    var cnt:Int = 0

    while(numX > 0){
        if (numX%10 == 3 || numX%10 == 6 || numX%10 == 9)
            return 1
        numX /= 10
    }
    return 0
}
