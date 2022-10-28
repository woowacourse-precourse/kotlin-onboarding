package onboarding

fun solution1CheckException(inputList: List<Int>): Boolean {
    //문제에서 정의한 예외를 다음과 같은 상황이라고 해석했음
    if(inputList.contains(1)||inputList.contains(400)) return true
    if(inputList[1]-inputList[0]!=1) return true
    return false
}

fun solution1Solve(inputList: List<Int>): Int {
    var addScore = 0
    var multipleScore = 1

    inputList.forEach { page ->
        var (tmpAddScore, tmpMultipleScore)=arrayOf(0, 1)
        page.toString().forEach { eachNum ->
            tmpAddScore += Character.getNumericValue(eachNum)
            tmpMultipleScore *= Character.getNumericValue(eachNum)
        }

        addScore= addScore.coerceAtLeast(tmpAddScore)
        multipleScore= tmpAddScore.coerceAtLeast(tmpMultipleScore)
    }

    return addScore.coerceAtLeast(multipleScore)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(solution1CheckException(pobi)||solution1CheckException(crong))
        return -1

    var (pobiScore, crongScore) = arrayOf(0, 0);

    pobiScore = solution1Solve(pobi)
    crongScore = solution1Solve(crong)

    return if (pobiScore > crongScore) 1
    else if (pobiScore < crongScore) 2
    else 0
}
