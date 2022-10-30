package onboarding

fun solution1(pobi: List<Int>,crong:List<Int>): Int {
    val pobiMaxList =mutableListOf<Int>()
    val crongMaxList = mutableListOf<Int>()
    for(i in pobi.indices) {
        var pobiPageIntList = pobi[i].toString().map{it.digitToInt()}
        var pobiTimes = 1
        for(j in pobiPageIntList) { pobiTimes *= j }
        pobiMaxList.add(if(pobiPageIntList.sum() >= pobiTimes) pobiPageIntList.sum() else pobiTimes)
    }
    val pobiMax = pobiMaxList.maxOf { it }
    for(i in crong.indices) {
        var crongPageIntList = crong[i].toString().map{ it.digitToInt() }
        var crongTimes = 1
        for(j in crongPageIntList) { crongTimes *= j }
        crongMaxList.add(if (crongPageIntList.sum() >= crongTimes) crongPageIntList.sum() else crongTimes)
    }
    val crongMax = crongMaxList.maxOf { it }
    return when {
        pobi[1]-pobi[0] !=1 && crong[1]-pobi[0] !=1 -> -1
        pobiMax > crongMax -> 1
        pobiMax < crongMax -> 2
        else  -> 0
    }
}