package onboarding

fun solution3(number: Int): Int {

    fun chunkNum(n: Int): IntArray {
        return n.toString().chunked(1).map { it.toInt() }.toIntArray()
    }

    return 0
}
