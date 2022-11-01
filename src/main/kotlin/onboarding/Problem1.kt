package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(!checkInputException(pobi) || !checkInputException(crong))
        return -1

    val pobisNumbers: ArrayList<Int> = arrayListOf()
    val crongsNumbers: ArrayList<Int> = arrayListOf()

    pobisNumbers.add(sumPageNum(pobi[0]))
    pobisNumbers.add(sumPageNum(pobi[1]))
    pobisNumbers.add(multiplyPageNum(pobi[0]))
    pobisNumbers.add(multiplyPageNum(pobi[1]))

    crongsNumbers.add(sumPageNum(crong[0]))
    crongsNumbers.add(sumPageNum(crong[1]))
    crongsNumbers.add(multiplyPageNum(crong[0]))
    crongsNumbers.add(multiplyPageNum(crong[1]))

    val maxPobi = getMax(pobisNumbers)
    val maxCrong = getMax(crongsNumbers)

    return getWinner(maxPobi, maxCrong)
}

fun checkInputException(pageList: List<Int>): Boolean{
    if(pageList[1] - pageList[0] != 1)
        return false
    if(pageList[0] < 3 || pageList[0] > 397)
        return false
    if(pageList[0] % 2 == 0)
        return false
    return true
}

fun sumPageNum(pageNum: Int): Int{
    var sum = 0
    var currNum = pageNum

    while(currNum > 0){
        sum += currNum % 10
        currNum /= 10
    }

    return sum
}

fun multiplyPageNum(pageNum: Int): Int{
    var mutiply = 1
    var currNum = pageNum

    while(currNum > 0){
        mutiply *= currNum % 10
        currNum /= 10
    }

    return mutiply
}

fun getMax(numbers: ArrayList<Int>): Int{
    return numbers.maxOrNull()!!
}

fun getWinner(pobiMax:Int, crongMax:Int): Int{
    return if(pobiMax > crongMax)
        1
    else if(pobiMax < crongMax)
        2
    else
        0
}
