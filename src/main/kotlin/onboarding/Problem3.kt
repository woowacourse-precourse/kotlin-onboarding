package onboarding

const val THREE = '3'
const val SIX = '6'
const val NINE = '9'
const val INITIAL_NUMBER = 0
const val LOOP_START_NUMBER = 1
fun solution3(number: Int): Int = countClap(number)

private fun countClap(number: Int): Int {
    val clapNumber = listOf(THREE, SIX, NINE)
    var clap = INITIAL_NUMBER
    for (i in LOOP_START_NUMBER .. number ) {
        i.toString().map { if (clapNumber.contains(it)) clap++ }
    }
    return clap
}


