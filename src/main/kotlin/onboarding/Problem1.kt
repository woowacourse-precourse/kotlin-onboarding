package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pl: Int = bestLeft(pobi[0])
    var pr: Int = bestRight(pobi[1])
    var cl: Int = bestLeft(crong[0])
    var cr: Int = bestRight(crong[1])

    var pb = bestLR(pl, pr)
    var cb = bestLR(cl, cr)

    if (pobi[0]+1 == pobi[1] && crong[0]+1 == crong[1]){
        if(pb>cb){
            return 1
        }
        if(pb<cb){
            return 2
        }
        if(pb == cb){
            return 0
        }
    }
    return -1
}

fun bestLeft(name: Int): Int{
    var bl = 0
    if(sumNum(name) > mulNum(name)){
        bl = sumNum(name)
    }else if(mulNum(name) > sumNum(name)){
        bl = mulNum(name)
    }else{
        bl = sumNum(name)
    }
    return bl
}

fun bestRight(name: Int): Int{
    var br: Int
    if(sumNum(name) > mulNum(name)){
        br = sumNum(name)
    }else if(mulNum(name) > sumNum(name)){
        br = mulNum(name)
    }else{
        br = sumNum(name)
    }
    return br
}

fun bestLR(a: Int, b: Int): Int{
    var bestlr: Int = 0
    if(a>b){
        bestlr = a
    }
    if(a<b){
        bestlr = b
    }
    return bestlr
}

fun sumNum(n: Int): Int{
    var input = n
    var answer = 0

    while (input != 0){
        answer += input % 10
        input /= 10
    }
    return answer
}

fun mulNum(n: Int): Int{
    var input = n
    var answer = 1

    while (input != 0){
        answer *= input % 10
        input /= 10
    }
    return answer
}