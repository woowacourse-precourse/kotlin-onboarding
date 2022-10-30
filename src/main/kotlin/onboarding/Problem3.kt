package onboarding

fun solution3(number: Int): Int  = (1..number)
    .joinToString("") { it.toString() }
    .filter { it == '3' || it == '6' || it == '9'}
    .length
