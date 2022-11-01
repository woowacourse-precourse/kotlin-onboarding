package onboarding

/**
 * 기능 목록
 * (1) 페이지 수를 잘못 기입한 예외 상황 검증 -> 예외 발생시 종료
 * (2) 포비와 크롱이 선택한 4개의 페이지 번호를 자릿수 별로 나누어 더하고, 곱한다
 * (3) 각 사용자가 가진 숫자 목록 중 가장 큰 숫자를 찾아 점수로 선택
 * (4) 포비의 숫자와 크롱의 점수를 비교하여 결과 산출
 * **/
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[0]+1!=pobi[1] || crong[0]+1!=crong[1]){ //예외사항 검증
        return -1 //종료
    }

    val pobiNumberList= mutableListOf<Int>()
    val crongNumberList= mutableListOf<Int>()

    pobiNumberList.addAll(getCalculatedNumbers(pobi[0])) //포비 - 왼쪽페이지
    pobiNumberList.addAll(getCalculatedNumbers(pobi[1])) //포비 - 오른쪽페이지
    crongNumberList.addAll(getCalculatedNumbers(crong[0])) //크롱 - 왼쪽페이지
    crongNumberList.addAll(getCalculatedNumbers(crong[1])) //크롱 - 오른쪽페이지

    pobiNumberList.sortDescending() //포비 숫자 - 내림차순 정렬
    crongNumberList.sortDescending() //크롱 숫자 - 내림차순 정렬

    var result = 0 //결과 (무승부)
    if(pobiNumberList[0]>crongNumberList[0]){ //포비가 이기는 경우
        result = 1
    }else if(pobiNumberList[0]<crongNumberList[0]){ //크롱이 이기는 경우
        result = 2
    }
    return result
}
private fun getCalculatedNumbers(pageNumber: Int) :List<Int>{
    var target = pageNumber
    val numList= mutableListOf<Int>()

    while (target>99){ //두자리수가 될 때까지 수를 10으로 나눠 한 자리씩 구한다
        numList.add(target%10)
        target/=10
    }
    numList.add(target%10)
    numList.add(target/10)

    var targetAdded = 0
    var targetMultiplied = 1
    for(i in 0 until numList.size){
        targetAdded += numList[i]
        targetMultiplied *= numList[i]
    }

    return listOf(targetAdded,targetMultiplied)
}