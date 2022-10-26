package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

fun getAddedDigitSum(number: Int): Int =
    number.toString()
        .fold(0) { total, digit ->
            total + Character.getNumericValue(digit)
        }

fun getMultipliedSum(number: Int): Int =
    number.toString()
        .fold(1) { total, digit ->
            total * Character.getNumericValue(digit)
        }