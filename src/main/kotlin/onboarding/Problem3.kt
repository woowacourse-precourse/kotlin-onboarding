package onboarding

fun solution3(number: Int): Int = Array(number) { (it + 1).toString() }.sumOf { it.count { c -> c == '3' || c == '6' || c == '9' } }

