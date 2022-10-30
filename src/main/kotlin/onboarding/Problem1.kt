package onboarding

class Const {
    companion object {
        const val WIN_POBI = 1
        const val WIN_CRONG = 2
        const val DRAW = 0
        const val EXCEPTION = -1

        const val MIN_PAGE = 1
        const val MAX_PAGE = 400
    }
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(isException(pobi) || isException(crong)) {
        return Const.EXCEPTION;
    }

    return getWinner(getScore(pobi), getScore(crong))
}

fun isException(pages: List<Int>): Boolean {
    if(pages[0]+1 != pages[1]) return true
    if(pages[0] % 2 != 1) return true
    if(pages[1] % 2 != 0) return true
    if(pages[0] <= Const.MIN_PAGE || pages[1] >= Const.MAX_PAGE) return true

    return false
}

fun getWinner(poby:Int, crong:Int) : Int {
    if(poby > crong) {
        return Const.WIN_POBI
    } else if(poby < crong) {
        return Const.WIN_CRONG
    }
    else {
        return Const.DRAW
    }
}

fun getScore(pages:List<Int>): Int {
    var score = 0

    for(page in pages) {
        score = Math.max(getSumOfDigits(page), score)
        score = Math.max(getMultipleOfDigits(page), score)
    }

    return score
}

fun getSumOfDigits(p:Int): Int {
    var sum = 0
    var page = p

    while(page > 0) {
        sum += page % 10
        page /= 10
    }

    return sum
}

fun getMultipleOfDigits(p:Int): Int {
    var mul = 1
    var page = p

    while(page > 0) {
        mul *= page % 10
        page /= 10
    }

    return mul
}