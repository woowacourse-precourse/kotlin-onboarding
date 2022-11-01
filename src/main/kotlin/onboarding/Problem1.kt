package onboarding

//기능 목록
/*
    1. 왼쪽 페이지 번호 비교.
    1-1. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더한다.
    1-2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 곱한다.
    1-3. 1-1, 1-2에서 구한 수를 비교한다.
    2. 오른쪽 페이지 번호 비교. 1.의 경우와 동일
    3. 1, 2. 중에서 가장 큰 수를 정한다.
    3-1. 1, 2.의 수를 비교
    4. 3.에서 나온 결과를 보고 알맞은 값을 return
    4-1. 포비가 이긴다면 1 return
    4-2. 크롱이 이긴다면 2 return
    4-3. 무승부 0 return
    4-4. 예외 사항은 -1 return
 */

//예외 사항
/*
    1. 페이지 수의 범위가 2~399를 벗어나는 경우
    2. 왼쪽 페이지가 홀수가 아닌 경우
    3. 오른쪽 페이지가 짝수가 아닌 경우
    4. 페이지의 번호가 연속되는 수가 아닌 경우
 */

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //프로그램 구현

// 예외사항 1. 페이지 수의 범위가 2~399를 벗어나는 경우 -1 return
    if(getArrangeError(pobi[0] == false)) return -1
    if(getArrangeError(crong[0] == false)) return -1
    if(getArrangeError(pobi[1] == false)) return -1
    if(getArrangeError(crong[1] == false)) return -1

    //1. 왼쪽 페이지 비교
    val pobiLeftResult = compare(pobi[0])
    val crongLeftResult = compare(crong[0])

    //2. 오른쪽 페이지 비교
    val pobiRightResult = compare(pobi[1])
    val crongRightResult = compare(crong[1])

    //3. 왼쪽, 오른쪽 비교
    val pobiBiggest = if(pobiLeftResult >= pobiRightResult) pobiLeftResult if(pobiRightResult >= pobiLeftResult) pobiRightResult
    val crongBiggest = if(crongLeftResult >= crongRightResult) crongLeftResult if(crongRightResult >= crongLeftResult) crongRightResult

    //4. 알맞은 값을 return
    if(pobiBiggest > crongBiggest){
        return 1
    }
    if(crongBiggest > pobiBiggest){
        return 2
    }
    if(pobiBiggest == crongBiggest){
        return 0
    }

}

// 예외사항 1. 페이지 수의 범위가 2~399를 벗어나는 경우
fun getArrangeError(pageNum : Int):Boolean{
    if(pageNum in 2..399) return true
    else return false
}

fun comparePageNum(pageNum : Int):Int{

    var sum = 0; var mul = 0

    while(pageNum != 0){
        sum += pageNum % 10
        mul *= pageNum % 10
        pageNum /= 10
    }

    if(sum >= mul){
        return sum
    }
    if(mul >= sum){
        return mul
    }

}
