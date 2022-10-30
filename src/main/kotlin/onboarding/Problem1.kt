package onboarding

import java.lang.NumberFormatException

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    try{
        if(checkInputValue(pobi,crong)){
            val pobiSumLeft = calculateEachDigitSum(pobi[0])
            val pobiSumRight = calculateEachDigitSum(pobi[1])

            val pobiSumValue = if(pobiSumLeft>pobiSumRight) pobiSumLeft else pobiSumRight
            var pobiMulLeft = calculateEachDigitMul(pobi[0])
            var pobiMulRight = calculateEachDigitMul(pobi[1])

            val pobiMulValue = if(pobiMulLeft>pobiMulRight) pobiMulLeft else pobiMulRight
            val pobiValue = if(pobiSumValue>pobiMulValue) pobiSumValue else pobiMulValue

            val crongSumLeft = calculateEachDigitSum(crong[0])
            val crongSumRight = calculateEachDigitSum(crong[1])

            val crongSumValue = if(crongSumLeft>crongSumLeft) crongSumRight else crongSumRight
            var crongMulLeft = calculateEachDigitMul(crong[0])
            var crongMulRight = calculateEachDigitMul(crong[1])

            val crongMulValue = if(crongMulLeft>crongMulRight) crongMulLeft else crongMulRight
            val crongValue = if(crongSumValue>crongMulValue) crongSumValue else crongMulValue

            return if(pobiValue>crongValue) 1 else if(pobiValue<crongValue) 2 else 0
        }else{
            return -1
        }
    }catch (e : NumberFormatException){
        return -1
    }
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
