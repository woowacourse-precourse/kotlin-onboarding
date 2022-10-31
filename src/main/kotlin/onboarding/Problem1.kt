package onboarding

const val ZEROCODE:Int  = 48

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(!isValidList(pobi) || !isValidList(crong))
        return -1

    val dif  = getMaxScore(crong)!! - getMaxScore(pobi)!!

    return when {
            dif > 0 -> 2
            dif == 0 -> 0
            else -> 1

    }
}

fun isValidList(pobi:List<Int>): Boolean {
    return pobi.size == 2 && (pobi[1] - pobi[0] == 1) && (pobi[0] % 2 == 1)
}

fun getMaxScore(pobi:List<Int>): Int?{

    val pobiScore = pobi.flatMap { listOf(it.toString().toList().fold(0){ sum, i -> sum + i.code - ZEROCODE},
                                            it.toString().toList().fold(1){ mul, i -> mul * (i.code - ZEROCODE)})}


    return pobiScore.maxOrNull()

}

fun main() {
    val pobi1 = listOf(99,102)
    val crong1 = listOf(211,212)
    println(solution1(pobi1, crong1))

}