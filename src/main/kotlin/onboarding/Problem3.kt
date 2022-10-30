package onboarding


fun count369(number: Int): Int {
    var count = 0
    val numberToString = number.toString()

    for (digit in numberToString) {
        if (digit == '3' || digit == '6' || digit == '9') {
            count++
        }
    }
    return count
}

fun countNumberOfClaps() {

}

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}
