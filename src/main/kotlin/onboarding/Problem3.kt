package onboarding

//- 3의 개수가 있을때마다 숫자가 올라가는 기능
const val THREE = '3'
const val SIX = '6'
const val NINE = '9'
const val INITIAL_NUMBER = 0
const val LOOP_START_NUMBER = 1
fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

private fun countClap(number: Int): Int {
    val clapNumber = listOf(THREE, SIX, NINE)
    var clap = INITIAL_NUMBER
    for (i in LOOP_START_NUMBER .. number ) {
        i.toString().map { if (clapNumber.contains(it)) clap++ }
    }
    return clap
}

