package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var scoreOfPobi = 0
    var scoreOfCrong = 0

    return getWinner(scoreOfPobi, scoreOfCrong)
}

fun getWinner(poby:Int, crong:Int) : Int {
    if(poby > crong) {
        return 1;
    } else if(poby < crong) {
        return 2;
    }
    else {
        return 0;
    }
}