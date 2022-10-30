package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    return 0
}

private fun checkStraightNum(list : List<Int>) : Boolean{
    return list[0]+1==list[1]
}

private fun checkOverNumPage(list : List<Int>) : Boolean{
    return !(list[0]>400 || list[1]>400 || list[0]<1 || list[1]<1)
}

private fun checkInputValue(list1 : List<Int>, list2 : List<Int>) : Boolean{
    return checkStraightNum(list1) && checkOverNumPage(list1) && checkStraightNum(list2) && checkStraightNum(list2)
}

private fun calculateEachDigitSum(value : Int) : Int{
    return value.toString().map {
        it.code - '0'.code
    }.sum()
}

private fun calculateEachDigitMul(value : Int) : Int{
    var result = 1
    for(element in value.toString().toCharArray()){
        result *= (element - '0'.code).code
    }
    return result
}
