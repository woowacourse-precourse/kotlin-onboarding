package onboarding

import java.lang.NumberFormatException

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    try{
        if(checkInputValue(pobi,crong)){
            val pobiSum1 = calculateEachDigitSum(pobi[0])
            val pobiSum2 = calculateEachDigitSum(pobi[1])

            val pobiSumValue = if(pobiSum1>pobiSum2) pobiSum1 else pobiSum2
            var pobiMul1Value = calculateEachDigitMul(pobi[0])
            var pobiMul2Value = calculateEachDigitMul(pobi[1])

            val pobiMulValue = if(pobiMul1Value>pobiMul2Value) pobiMul1Value else pobiMul2Value
            val pobiValue = if(pobiSumValue>pobiMulValue) pobiSumValue else pobiMulValue

            //크롱값
            val crongSum1 = calculateEachDigitSum(crong[0])
            val crongSum2 = calculateEachDigitSum(crong[1])

            val crongSumValue = if(crongSum1>crongSum2) crongSum1 else crongSum2
            var crongMul1Value = calculateEachDigitMul(crong[0])
            var crongMul2Value = calculateEachDigitMul(crong[1])

            val crongMulValue = if(crongMul1Value>crongMul2Value) crongMul1Value else crongMul2Value
            val crongValue = if(crongSumValue>crongMulValue) crongSumValue else crongMulValue

            return 0
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
