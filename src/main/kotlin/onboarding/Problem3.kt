package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
    return countClap(number)
}

fun countClap(number: Int): Int{
    val clapNumberList = listOf('3','6','9')
    var count = 0
    for(i in 1 until number+1) {
        i.toString().map{ if(clapNumberList.contains(it))
            count++
        }
    }
    return count
}
