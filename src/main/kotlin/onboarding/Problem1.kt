package onboarding

fun solution1(pobi: List<Int>,crong:List<Int>): Int {
    return try {
        when {
            pobi[1]-pobi[0] !=1 && crong[1]-pobi[0] !=1 -> -1
            GetPlayerScore(pobi) > GetPlayerScore(crong) -> 1
            GetPlayerScore(pobi) > GetPlayerScore(crong) -> 2
            else  -> 0
        }
    } catch (e:Exception) {
        return -1
    }
}

private fun GetPlayerScore(palyer:List<Int>):Int{
    var totalSum = 0
    var totalTimes =1
    for(i in palyer.indices) {
        var playerPageIntList = palyer[i].toString().map{it.digitToInt() }
           totalSum = playerPageIntList.sum()
            totalTimes = 1
            for(j in playerPageIntList) { totalTimes *= j }
        }
    return if(totalSum >= totalTimes) totalSum else return totalTimes
}
