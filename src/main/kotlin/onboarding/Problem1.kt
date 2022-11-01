package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if ( isException(pobi) || isException(crong) ) {
        return -1
    }



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
    var result = 0

    while (input != 0) {
        result += input % 10
        input /= 10
    }

    return result
}





