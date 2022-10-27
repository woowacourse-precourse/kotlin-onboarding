package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun startGame(start : Int, end: Int, count: Int) : Int {
    if (start == end + 1) {
        return count
    }
    return startGame(start + 1, end, clapCounter(start, count))
}