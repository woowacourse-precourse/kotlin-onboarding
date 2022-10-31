package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!checkInputException(pobi) || !checkInputException(crong))
        return -1

    return 0
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
    // TODO: 2022-10-31
    return 0
}

fun multiplyPageNum(pageNum: Int): Int{
    // TODO: 2022-10-31
    return 0
}

fun getMax(numbers: List<Int>): Int{
    // TODO: 2022-10-31
    return 0
}

fun getWinner(pobiMax:Int, crongMax:Int): Int{
    // TODO: 2022-10-31
    return 0
}
