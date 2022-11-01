package onboarding

const val START_NUMBER = 1
const val THREE = 3
const val SIX = 6
const val NINE = 9
const val TEN = 10

fun solution3(number: Int): Int {
    return startGame(START_NUMBER, number, 0)
}

fun startGame(start : Int, end: Int, count: Int) : Int {
    if (start == end + 1) {
        return count
    }
    return startGame(start + 1, end, clap(start, count))
}

fun clap(number: Int, count : Int) : Int {
    if (number == 0) {
        return count
    }
    if (number % TEN == THREE || number % TEN == SIX || number % TEN == NINE) {
        return clap(number / TEN, count + 1)
    }
    return clap(number / TEN, count)
}