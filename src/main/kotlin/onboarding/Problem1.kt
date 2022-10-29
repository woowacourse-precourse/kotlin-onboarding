package onboarding

fun solution1(pobi: List<Int>,crong:List<Int>): Int {
    val pobiMaxList =mutableListOf<Int>()
    val crongMaxList = mutableListOf<Int>()
    var pobiMax = 0
    var crongMax = 0
    for(i in pobi.indices) {
        var pobiPageIntList = pobi[i].toString().map{it.digitToInt()}
        var pobiTimes = 1
        for(i in pobiPageIntList) {
            pobiTimes *= i
        }
        pobiMaxList.add(if(pobiPageIntList.sum() >= pobiTimes) pobiPageIntList.sum() else pobiTimes)
    }
    pobiMax = pobiMaxList.maxOf { it }
    for(i in crong.indices) {
        var crongPageIntList = crong[i].toString().map{ it.digitToInt() }
        var crongTimes = 1
        for(i in crongPageIntList) { crongTimes *= i }
        crongMaxList.add(if (crongPageIntList.sum() >= crongTimes) crongPageIntList.sum() else crongTimes)
    }
    crongMax = crongMaxList.maxOf { it }
    return when {
        pobi[1]-pobi[0] !=1 && crong[1]-pobi[0] !=1 -> -1
        pobiMax > crongMax -> 1
        pobiMax < crongMax -> 2
        else  -> 0
    }
}
fun main () {
    val a = listOf<Int>(97,98)
    val b = listOf<Int>(197, 198)
    val c = listOf<Int>(131, 132)
    val d = listOf<Int>(211, 212)
    val e = listOf<Int>(99, 102)
    val f = listOf<Int>(211, 212)
    print(solution1(c,d))

}