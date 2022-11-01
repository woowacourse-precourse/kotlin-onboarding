package onboarding

val SCALES = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

fun getNumberOfScale(remainder: Int, scale:Int): Int {
    return remainder/scale
}
fun solution5(money: Int): List<Int> {
    var answer = mutableListOf<Int>()
    var remainder = money
    for(scale in SCALES) {
        answer.add(getNumberOfScale(remainder, scale))
        remainder %= scale
    }
    return answer
}
