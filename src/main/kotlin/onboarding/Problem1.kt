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
    var scoreOfPobi = 0
    var scoreOfCrong = 0

    return getWinner(scoreOfPobi, scoreOfCrong)
}

fun getWinner(poby:Int, crong:Int) : Int {
    if(poby > crong) {
        return Const.WIN_POBI;
    } else if(poby < crong) {
        return Const.WIN_CRONG;
    }
    else {
        return Const.DRAW;
    }
}