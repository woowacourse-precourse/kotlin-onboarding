package onboarding

fun solution3(number: Int): Int {
    return startGame(1, number, 0)
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
    if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
        return clap(number / 10, count + 1)
    }
    return clap(number / 10, count)
}