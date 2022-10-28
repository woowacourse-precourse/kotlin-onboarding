package onboarding

import kotlin.math.max
fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // 예외 처리
    if (!exceptionCheck(pobi[0], pobi[1]) || !exceptionCheck(crong[0], crong[1])){
        return -1
    }

    // 포비와 크롱의 최대 점수
    val pobiNum = pobi.toMaxNum()
    val crongNum = crong.toMaxNum()

    // 점수 비교
    return compareScore(pobiNum, crongNum)

}

// 페이지 예외 처리 기능
fun exceptionCheck(startPageNum : Int, endPageNum : Int) : Boolean{
    // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지, 양쪽 페이지 차이가 1인지, 페이지 쪽수가 1부터 400안에 있는지
    return startPageNum % 2 != 0
            && endPageNum - startPageNum == 1
            && startPageNum in 1..400
            &&endPageNum in 1 ..400
}


// 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구하는 기능
fun List<Int>.toMaxNum() : Int{

    return maxOf {
        val target = it.toString()
        max(
            target.fold(0){ acc, i -> acc + i.digitToInt()},
            target.fold(1){ acc, i -> acc * i.digitToInt()}
        )
    }
}

//pobi와 crong의 점수를 비교하는 기능
fun compareScore(pobiScore : Int, crongScore : Int) : Int{
    return if (pobiScore > crongScore) 1
    else if (pobiScore < crongScore) 2
    else 0
}
