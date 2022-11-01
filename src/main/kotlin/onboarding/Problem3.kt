package onboarding

fun solution3(number: Int): Int {

    var clap = 0

    fun chunkNum(n: Int): IntArray {
        return n.toString().chunked(1).map { it.toInt() }.toIntArray()
    }

    for (i in 1..number) {
        val chunkedNumList = chunkNum(i)
        for (j in chunkedNumList) {
            if (j == 3 || j == 6 || j == 9) {
                clap += 1
            }
        }
    }

    return clap
}
