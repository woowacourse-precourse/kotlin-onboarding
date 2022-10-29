package onboarding

import java.lang.Math.max

fun solution1CheckException(inputList: List<Int>): Boolean {
    //예외 상황
    //0. 오른쪽 페이지가 홀수가 아니거나 왼쪽 페이지가 짝수가 아닌 경우
    //1. 첫페이지나 마지막 페이지 펼치기
    //2. 오른쪽 페이지와 왼쪽 페이지 수의 차이가 1이 아닌 경우
    if(inputList[0]%2!=1 || inputList[1]%2!=0)
    if (inputList.contains(1) || inputList.contains(400)) return true
    if (inputList[1] - inputList[0] != 1) return true
    return false
}

fun solution1calcMultipleScore(inputList: List<Int>): Int {
    var multipleScore = 1

    inputList.forEach { page ->
        var tmpMultipleScore = 1
        //각 페이지의 숫자 하나씩 곱하기
        page.toString().forEach { eachNum ->
            tmpMultipleScore *= Character.getNumericValue(eachNum)
        }
        multipleScore = multipleScore.coerceAtLeast(tmpMultipleScore)
    }

    return multipleScore
}

fun solution1calcAddScore(inputList: List<Int>): Int {
    var addScore = 0

    inputList.forEach { page ->
        var tmpAddScore = 0
        //각 페이지의 숫자 하나씩 더하기
        page.toString().forEach { eachNum ->
            tmpAddScore += Character.getNumericValue(eachNum)
        }
        addScore = addScore.coerceAtLeast(tmpAddScore)
    }

    return addScore
}

fun solution1whoWin(pobiScore:Int, crongScore:Int):Int{
    return if (pobiScore > crongScore) 1
    else if (pobiScore < crongScore) 2
    else 0
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (solution1CheckException(pobi) || solution1CheckException(crong))
        return -1
    var (pobiScore, crongScore) = arrayOf(0, 0);

    pobiScore = solution1calcMultipleScore(pobi).coerceAtLeast(solution1calcAddScore(pobi))
    crongScore = solution1calcMultipleScore(crong).coerceAtLeast(solution1calcAddScore(crong))

    return solution1whoWin(pobiScore, crongScore)
}
