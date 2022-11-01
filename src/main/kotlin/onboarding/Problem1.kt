package onboarding



fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if ( isException(pobi) || isException(crong) ) {
        return -1
    }

    determineMyScore( pageNumberAdd(pobi[0]), pageNumberMul(pobi[0]), pageNumberAdd(pobi[1]), pageNumberMul(pobi[1]) )
    determineMyScore( pageNumberAdd(crong[0]), pageNumberMul(crong[0]), pageNumberAdd(crong[1]), pageNumberMul(crong[1]) )

}


fun isException(numberList : List<Int>) : Boolean {
    if ( numberList[1] - numberList[0] != 1) {
        return true
    }
    if (numberList[0] < 1 || numberList[1] > 400) {
        return true
    }
    if( numberList[0] % 2 != 1 || numberList[1] % 2 != 0 ) {
        return true
    }

    return false
}

fun pageNumberAdd(num: Int) : Int {
    var input = num
    var addResult = 0

    while (input != 0) {
        addResult += input % 10
        input /= 10
    }

    return addResult
}

fun pageNumberMul(num: Int) : Int {
    var input = num
    var mulResult = 1

    while (input != 0) {
        mulResult *= input % 10
        input /= 10
    }

    return mulResult
}

fun determineMyScore(addNumLeft : Int, mulNumLeft : Int, addNumRight : Int, mulNumRight : Int) : Int {
    return maxOf(addNumLeft, mulNumLeft, addNumRight, mulNumRight)
}




