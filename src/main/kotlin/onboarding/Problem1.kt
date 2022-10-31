package onboarding

/**
 * 기능 목록
 * (1) 페이지 수를 잘못 기입한 예외 상황 검증 -> 예외 발생시 종료
 * (2) 포비와 크롱이 선택한 4개의 페이지 번호를 자릿수 별로 나누어 더하고, 곱한다
 * (3) 각 사용자가 가진 숫자 목록 중 가장 큰 숫자를 선택한다
 * (4) 포비의 숫자와 크롱의 숫자를 비교하여 결과 산출
 * **/
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(pobi[0]+1!=pobi[1] || crong[0]+1!=crong[1]){ //예외사항 검증
        return -1 //종료
    }

    return 0
}