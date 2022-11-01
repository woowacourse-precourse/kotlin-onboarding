package onboarding

fun solution3(number: Int): Int {
    var clapCount = 0

    for (curNum: Int in 1..number) {
        curNum.toString().forEach {
            when (it) { '3', '6', '9' -> clapCount++ }
        }
    }
    return clapCount
}
